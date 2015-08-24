package com.unionPay.bll;
import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBHelper {
	
	/**
	 * Sington
	 */
	static DBHelper DBHelperInstance = null;
	private ComboPooledDataSource cpds = null;
	
	public DBHelper() {
	}


	public synchronized static DBHelper GetInstance()
	{
		if(DBHelperInstance == null) DBHelperInstance = new DBHelper();
		return DBHelperInstance;
	}
	private Logger logger = LogUtil.getSysLogger();
//	private DBConfig dbConfig = null;
	
	public boolean initDB(Properties props){
		boolean isSuccess = false;
		try {
			cpds = new ComboPooledDataSource();
			cpds.setDriverClass(props.getProperty("c3p0.driverClass"));
			cpds.setJdbcUrl(props.getProperty("c3p0.jdbcUrl"));
			cpds.setUser(props.getProperty("c3p0.user"));
			cpds.setPassword(props.getProperty("c3p0.password"));
			
			/*cpds.setJdbcUrl(dbConfig.getConnUrl());
			cpds.setUser(dbConfig.getUserName());
			cpds.setPassword(dbConfig.getPwd());*/
			cpds.setInitialPoolSize(Integer.parseInt(props.getProperty("c3p0.initialPoolSize").trim()));
			cpds.setMinPoolSize(Integer.parseInt(props.getProperty("c3p0.minPoolSize").trim()));
			cpds.setMaxPoolSize(Integer.parseInt(props.getProperty("c3p0.maxPoolSize").trim()));
			cpds.setAcquireIncrement(Integer.parseInt(props.getProperty("c3p0.acquireIncrement").trim()));
			cpds.setIdleConnectionTestPeriod(Integer.parseInt(props.getProperty("c3p0.idleConnectionTestPeriod").trim()));
//			cpds.setTestConnectionOnCheckout(props.getProperty("testConnectionOnCheckout"));
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		}
		return isSuccess;
		
	}

	

	public Connection GetConnection()
	{
		Connection conn = null;
		
		
		try {
			conn = cpds.getConnection();
		} catch (SQLException e) {
			//logger.fatal("获取连接失败，原因：" + e.getMessage());
			logger.fatal("Failed to get DB connection, reason:" + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal("Exception occurs when getting DB connection, reason:" + e.getMessage());
		}
		
//		try {
//			conn = DriverManager.getConnection(dbConfig.getConnUrl(),
//					dbConfig.getUserName(),
//					dbConfig.getPwd());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if (conn == null) {
			logger.warn("DB connection is null!");
		} 
		
		return conn;
	}
	
	
	public void CloseConnection(Connection conn)
	{
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch( Exception e ) { e.printStackTrace( ); } 
		}
	}
	
	public void ReleaseDatabasePool(){
		cpds.close();
	}
}
