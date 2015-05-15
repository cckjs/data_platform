package com.yy.data.platform.influence.weibo;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.yy.data.platform.influence.weibo.bean.Feature;
import com.yy.data.platform.influence.weibo.bean.TimeLineFeature;

public class InfluenceCompute {

	public double compute(Feature feature) {
		double influence = 0.0;
		if (feature.getUserFeature() == null
				&& CollectionUtils.isEmpty(feature.getTimelineFeatures())) {
			return influence;
		}
		List<TimeLineFeature> timeLines = feature.getTimelineFeatures();
		int count = 0;
		for (TimeLineFeature tlf : timeLines) {
			influence += tlf.timeLineInfluence();
			count++;
		}
		if (count == 0) {
			influence = feature.getUserFeature().userFeatureInfluence();
		} else {
			influence = influence / count
					+ feature.getUserFeature().userFeatureInfluence();
		}
		return influence;
	}
}
