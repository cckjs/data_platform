package com.yy.hbase;

import com.test.spring.SpringUtils;
import com.yy.data.platform.hbase.template.HbaseTemplate;

public class HbaseTemplateTest {

	public static void main(String[] args){
		HbaseTemplate template = SpringUtils.getBean(HbaseTemplate.class);
		System.out.println(template.getDataSource());
	
	}
}
