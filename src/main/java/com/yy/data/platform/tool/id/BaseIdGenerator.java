package com.yy.data.platform.tool.id;

import com.yy.data.platform.tool.id.datasource.IDDataSourcePool;

public class BaseIdGenerator {

	protected IDDataSourcePool dsPool;

	public IDDataSourcePool getDsPool() {
		return dsPool;
	}

	public void setDsPool(IDDataSourcePool dsPool) {
		this.dsPool = dsPool;
	}
}
