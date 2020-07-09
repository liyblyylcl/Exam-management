package com.lhr.share;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//数据库连接类
public class DBConnect {

	
	static Connection con = null;
	static Statement stm = null;

	// 返回一个Statement
	public static Statement dataBaseConnect() {

		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// 加载驱动程序
			// 数据库路径
			String dbPath = "jdbc:odbc:MS Access Database;DBQ=数据库文件\\考试管理系统数据库.mdb";
			con = DriverManager.getConnection(dbPath);// 打开数据库连接
			stm = con.createStatement();// 提交查询
			System.out.println("加载驱动OK。。。连接数据库OK。。。。。。。。。");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动程序异常");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stm;
	}

}
