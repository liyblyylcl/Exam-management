package com.lhr.share;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//���ݿ�������
public class DBConnect {

	
	static Connection con = null;
	static Statement stm = null;

	// ����һ��Statement
	public static Statement dataBaseConnect() {

		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");// ������������
			// ���ݿ�·��
			String dbPath = "jdbc:odbc:MS Access Database;DBQ=���ݿ��ļ�\\���Թ���ϵͳ���ݿ�.mdb";
			con = DriverManager.getConnection(dbPath);// �����ݿ�����
			stm = con.createStatement();// �ύ��ѯ
			System.out.println("��������OK�������������ݿ�OK������������������");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�������������쳣");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return stm;
	}

}
