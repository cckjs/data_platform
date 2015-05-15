package com.yy.influence;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

import com.test.spring.SpringUtils;
import com.yy.data.platform.hbase.common.callback.HbaseCallBack;
import com.yy.data.platform.hbase.template.HbaseTemplate;
import com.yy.data.platform.influence.weibo.InfluenceCompute;
import com.yy.data.platform.influence.weibo.bean.Feature;
import com.yy.data.platform.influence.weibo.bean.TimeLineFeature;
import com.yy.data.platform.influence.weibo.bean.UserFeature;

public class InfluenceTest {

	private HbaseTemplate template = SpringUtils.getBean(HbaseTemplate.class);

	private static final long oneDay = 1000*60*60*24;

	public Feature getFeature(final String uid, final Date starttime,
			final Date endtime) throws Exception {

		return template.execute("hntd_collect_weibo_user_weibo",
				new HbaseCallBack<Feature>() {

					public Feature doInTable(HTableInterface table)
							throws Exception {
						Scan scan = new Scan();
						scan.setStartRow(((Long.MAX_VALUE - endtime.getTime())
								+ "_" + uid).getBytes());
						scan.setStopRow(((Long.MAX_VALUE - starttime.getTime())
								+ "_" + uid).getBytes());
						Filter filter = new SingleColumnValueFilter("weibo_info".getBytes(),"uid".getBytes(),  CompareFilter.CompareOp.EQUAL,uid.getBytes());
						scan.setFilter(filter);
						System.out.println(scan);
						ResultScanner resultScanner = table.getScanner(scan);
						Iterator<Result> iterator = resultScanner.iterator();
						List<TimeLineFeature> timeLineFeatures = new ArrayList<TimeLineFeature>();
						Feature feature = new Feature();
						UserFeature userFeature = new UserFeature();
						TimeLineFeature timeLineFeature = null;
						Result temp = null;
						int count =0;
						while (iterator.hasNext()) {
							temp = iterator.next();
							timeLineFeature = new TimeLineFeature();
							timeLineFeature.setCommentNum(Bytes.toInt(temp
									.getValue("weibo_info".getBytes(),
											"comments_count".getBytes())));
							timeLineFeature.setRepostNum(Bytes.toInt(temp
									.getValue("weibo_info".getBytes(),
											"reposts_count".getBytes())));
							timeLineFeature.setTimelineId(Bytes.toString(temp
									.getValue("weibo_info".getBytes(),
											"mid".getBytes())));
							timeLineFeature.setUserId(Bytes.toString(temp
									.getValue("weibo_info".getBytes(),
											"uid".getBytes())));
							if(StringUtils.isBlank(timeLineFeature.getUserId())){
								continue;
							}
							timeLineFeatures.add(timeLineFeature);
							System.out.println(count+++","+timeLineFeature.getUserId()+"");
						}
						userFeature.setCommentCount(0);
						userFeature.setPublishCount(timeLineFeatures.size());
						userFeature.setStartTime(starttime);
						userFeature.setEndTime(endtime);
						feature.setTimelineFeatures(timeLineFeatures);
						feature.setUserFeature(userFeature);
						return feature;
					}
				});
	}

	public static void main(String[] args) throws Exception {
		InfluenceTest test = new InfluenceTest();
		InfluenceCompute influence = new InfluenceCompute();
		Feature feature = test.getFeature("2656274875", new Date(new Date().getTime()-1*oneDay), new Date());
		System.out.println(influence.compute(feature));
	}
}
