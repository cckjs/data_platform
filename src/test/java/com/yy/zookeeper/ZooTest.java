package com.yy.zookeeper;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.test.id.ThreadPool;
import com.yy.data.platform.zookeeper.operator.ZookeeperTool;

public class ZooTest {

	public static void main(String[] args) throws InterruptedException {
		ZookeeperTool tool = new ZookeeperTool();
		ThreadPool pool = new ThreadPool(2, 20, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
		String zkString = "192.168.1.201:2181";
		int sessionTimeOut = 10;
		for(int i=0;i<20;i++){
			pool.executeThread(new ZooThread(tool, zkString, sessionTimeOut));
		}
		pool.shutDown(false);
		pool.monitorThreadPool();
	}
}
