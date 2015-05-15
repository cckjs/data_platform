package com.yy.data.platform.tool.id.datasource;

import java.util.Hashtable;
import java.util.Map;

import com.yy.data.platform.util.RandomUtil;

public class IDDataSourcePool {

	private int dsNum;
	
	private Map<Integer,IDDataSource> dsPool = new Hashtable<Integer,IDDataSource>();

	public int getDsNum() {
		return dsNum;
	}

	public void setDsNum(int dsNum) {
		this.dsNum = dsNum;
	}

	public Map<Integer, IDDataSource> getDsPool() {
		return dsPool;
	}

	public void setDsPool(Map<Integer, IDDataSource> dsPool) {
		this.dsPool = dsPool;
	}
	
	public IDDataSource getRDBMSDataSource(){
		return dsPool.get(RandomUtil.randomN(dsNum));
	}
}
