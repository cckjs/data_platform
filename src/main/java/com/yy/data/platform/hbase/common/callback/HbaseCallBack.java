package com.yy.data.platform.hbase.common.callback;

import org.apache.hadoop.hbase.client.HTableInterface;

public interface HbaseCallBack<T> {

	T doInTable(HTableInterface table) throws Exception;
}
