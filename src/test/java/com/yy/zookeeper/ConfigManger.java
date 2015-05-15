package com.yy.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

import com.yy.data.platform.zookeeper.operator.ZookeeperTool;

public class ConfigManger {

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZookeeperTool tool = new ZookeeperTool();
		String zkString = "192.168.1.201:2181";
		int sessionTimeOut = 60 * 1000;
		ZooKeeper zk = tool.getConnection(zkString, sessionTimeOut);
//		zk.create("/config", "myconfig_data".getBytes(), Ids.OPEN_ACL_UNSAFE,
//				CreateMode.PERSISTENT);
		zk.setData("/config", "myconfig_data3".getBytes(), -1);
	}
}
