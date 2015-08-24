package com.unionPay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unionPay.bll.DBHelper;
import com.unionPay.bll.UPOPDao;

/**
 * Servlet implementation class UPOPCallBack
 */
public class StartupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Connection conn = DBHelper.GetInstance().GetConnection();
		PrintWriter out = response.getWriter();
		Map paramMaps = request.getParameterMap();
		Map<String,String> uMap = new HashMap<String, String>();
		for(Iterator iter = paramMaps.entrySet().iterator();iter.hasNext();){
			Map.Entry element = (Map.Entry)iter.next();  
			String strParamName = element.getKey().toString();
			Object val = element.getValue();
			String strParamVal = "";
			if (val instanceof String) {
				strParamVal = (String) val;
			}else if(val instanceof String[]){
				strParamVal = ((String[])val)[0];
			}
			uMap.put(strParamName, strParamVal);
		}
		try {
			UPOPDao.insert(conn,uMap);
			out.print("保存成功");
		} catch (SQLException e) {
			out.print("保存失败");
			e.printStackTrace();
		} finally {
			DBHelper.GetInstance().CloseConnection(conn);
		}
		out.flush();
		out.close();
	}

}
