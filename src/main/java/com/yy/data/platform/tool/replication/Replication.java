package com.yy.data.platform.tool.replication;

import com.yy.data.platform.tool.replication.bean.ShardRoute;

public interface Replication {

	/**
	 * 获取写路由
	 * @param business
	 * @param bussinessId
	 * @return
	 * @throws Exception
	 */
	public ShardRoute findWriteRoute(String business, long bussinessId)
			throws Exception;
    /**
     * 获取读路由
     * @param business
     * @param bussinessId
     * @return
     * @throws Exception
     */
	public ShardRoute findReadRoute(String business, long bussinessId)
			throws Exception;
}
