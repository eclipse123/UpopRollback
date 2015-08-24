package com.unionPay.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class UPOPDao {

	public static void insert(Connection conn, Map<String, String> uMap) throws SQLException {
		String strSql = "INSERT INTO `tbl_upop_msg_log_1` (`version`, `cert_id`, `signature`, `encoding`, `txn_type`, `txn_sub_type`, `biz_type`, `access_type`, " +
				"`mer_id`, `order_id`, `txn_time`, `acc_no`, `txn_amt`, `currency_code`, `req_reserved`," +
				" `reserved`, `query_id`, `resp_code`, `resp_msg`, `settle_amt`, `settle_currency_code`, " +
				"`settle_date`, `trace_no`, `trace_time`, `exchange_date`, `exchange_rate`) VALUES ( ?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?, ?, ?, ?, ? )";

//		boolean isSuccess = false;
		
		PreparedStatement psts;
		try {
			psts = conn.prepareStatement(strSql);
			Integer index = 1;
			psts.setString(index++, uMap.get("version"));
			psts.setString(index++, uMap.get("certId"));
			psts.setString(index++, uMap.get("signature"));
			psts.setString(index++, uMap.get("encoding"));
			psts.setString(index++, uMap.get("txnType"));
			psts.setString(index++, uMap.get("txnSubType"));
			psts.setString(index++, uMap.get("bizType"));
			psts.setString(index++, uMap.get("accessType"));
//			psts.setString(index++, uMap.get("signMethod"));
			psts.setString(index++, uMap.get("merId"));
			psts.setString(index++, uMap.get("orderId"));
			psts.setString(index++, uMap.get("txnTime"));
			psts.setString(index++, uMap.get("accNo"));
			psts.setString(index++, uMap.get("txnAmt"));
			psts.setString(index++, uMap.get("currencyCode"));
			psts.setString(index++, uMap.get("reqReserved"));
			psts.setString(index++, uMap.get("reserved"));
			psts.setString(index++, uMap.get("queryId"));
			psts.setString(index++, uMap.get("respCode"));
			psts.setString(index++, uMap.get("respMsg"));
			psts.setString(index++, uMap.get("settleAmt"));
			psts.setString(index++, uMap.get("settleCurrencyCode"));
			psts.setString(index++, uMap.get("settleDate"));
			psts.setString(index++, uMap.get("traceNo"));
			psts.setString(index++, uMap.get("traceTime"));
			psts.setString(index++, uMap.get("exchangeDate"));
			psts.setString(index++, uMap.get("exchangeRate"));
//			psts.setString(index++, uMap.get("CardTransData"));
			psts.execute();
			LogUtil.getSysLogger().info("success to save databse");
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getSysLogger().error("fail to save databse");
			throw e;
		}

		
	}


}
