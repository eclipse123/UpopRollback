package com.unionPay.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

import com.unionPay.bll.DBHelper;
import com.unionPay.bll.LogUtil;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	private void initLog() {
		Properties props = new Properties();
		InputStream ips;
		try {
			ips = getServletContext().getResourceAsStream("config"+System.getProperty("file.separator")+"log4j.properties");
			props.load(ips);
			ips.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		PropertyConfigurator.configure(props);
//		PropertyConfigurator.configure("config"+System.getProperty("file.separator")+"log4j.properties");
//		Log4jConfigurer.initLogging("log4j.properties", 60000);
		
	}
	private boolean initDB() {
		Properties props = new Properties();
		InputStream ips = getServletContext().getResourceAsStream("config"+System.getProperty("file.separator")+"c3p0.properties");
		try {
			props.load(ips);
			ips.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean isSuccess = DBHelper.GetInstance().initDB(props);
		return isSuccess;
	}

	
	
   public void init(){
	   boolean initialRs =false;
//	   System.exit(0);
	   
	   try {
			initLog();
		} catch (Exception e) {
			System.out.println("[System Initialization] fatal error: can't read log4j configure file, the reason is: " + e.getMessage());
			
			//System.out.println("读取log4j配置文件失败，原因：" + e.getMessage());
			return;
		}
		LogUtil.getSysLogger().debug("[System Initialization] read log4j configure file success!");
	   
		try {
			initialRs = initDB();
		
		} catch (Exception e) {
			LogUtil.getSysLogger().error("[System Initialization] fails on decrypting DB information，the reason is" + e.getMessage());
			return;
		}

		if(initialRs == false){
			return;
		}else{
			LogUtil.getSysLogger().debug("[System Initialization] read DB configure file success!");
		}
   }



	

}
