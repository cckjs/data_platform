package com.test.id;

import java.sql.SQLException;

import com.test.spring.SpringUtils;
import com.yy.data.platform.tool.id.IDFactory;

public class IDCreateThread implements Runnable {

	public void run() {
		IDFactory idtools = SpringUtils.getBean(IDFactory.class);
		try {
			System.out.println(Thread.currentThread().getName() + "  start");

			System.out.println(Thread.currentThread().getName() + "id=["
					+ idtools.getId("user") + "]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
