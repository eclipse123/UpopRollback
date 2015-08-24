package com.unionPay.bll;

import org.apache.log4j.Logger;

public class LogUtil  {

	public static final String WORKDIR = "";
	
	
	private static final String LOGGER_SYS = "LOGGER_SYS"; 
	
	public static Logger getSysLogger(){
		return Logger.getLogger(LOGGER_SYS);
	}
	
}
