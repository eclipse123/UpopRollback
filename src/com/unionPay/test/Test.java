package com.unionPay.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Stack;

public class Test {  
//    public static final String url = "jdbc:mysql://127.0.0.1/app";  
//    public static final String name = "com.mysql.jdbc.Driver";  
//    public static final String user = "root";  
//    public static final String password = "111111";  
//  
//    public Connection conn = null;  
//    public PreparedStatement pst = null;  
//    public Test(){
//    	
//    }
//    public Test(String sql) {  
//        try {  
//            Class.forName(name);//指定连接类型  
//            conn = DriverManager.getConnection(url, user, password);//获取连接  
//            pst = conn.prepareStatement(sql);//准备执行语句  
//            pst.execute();
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }  
//  
//    public void close() {  
//        try {  
//            this.conn.close();  
//            this.pst.close();  
//        } catch (SQLException e) {  
//            e.printStackTrace();  
//        }  
//    }  
//    public static void main(String[] args) throws IOException {
//    	String sql = " INSERT INTO `t_user` ( `name`, `age`, `img`) VALUES ( '张三', '12', NULL)";
// 
//		new Test(sql);
//    	String s = Integer.toString(10);
//    	System.out.println(s);
    	  //1、使用File类指定一个文件名  
//        File file=new File("d:"+File.separator+"test.txt");  
//        //2、创建OutputStream类，并为此实例化对象  
//        OutputStream out=new FileOutputStream(file);  
//        //3、执行写入操作  
//        String str="Hello world";  
//        byte b[]=str.getBytes();  
//        out.write(b);  
//        //4、关闭输入流  
//        out.close();  
//    	hello();
//    	Integer t=10;
//    	System.out.println(Integer.toHexString(100));
//	}
//    
//    public String toString(){
//    	return "hello";
//    }
	public static void main(String[] args) {
        Stack stack = new Stack(); // 创建堆栈对象 
        System.out.println("11111, absdder, 29999.3 三个元素入栈"); 
        stack.push(new Integer(11111)); //向 栈中 压入整数 11111
        printStack(stack);  //显示栈中的所有元素

        stack.push("absdder"); //向 栈中 压入
        printStack(stack);  //显示栈中的所有元素

        stack.push(new Double(29999.3)); //向 栈中 压入
        printStack(stack);  //显示栈中的所有元素

        String s = new String("absdder");
        System.out.println("元素absdder在堆栈的位置"+stack.search(s));      
        System.out.println("元素11111在堆栈的位置"+stack.search(11111));

        System.out.println("11111, absdder, 29999.3 三个元素出栈"); //弹出 栈顶元素 
        System.out.println("元素"+stack.pop()+"出栈");
        printStack(stack);  //显示栈中的所有元素
        System.out.println("元素"+stack.pop()+"出栈");
        printStack(stack);  //显示栈中的所有元素
        System.out.println("元素"+stack.pop()+"出栈");
        printStack(stack);  //显示栈中的所有元素

 
    }

    private static void printStack(Stack<Integer> stack ){
        if (stack.empty())
            System.out.println("堆栈是空的，没有元素");
            else {
                System.out.print("堆栈中的元素：");
                Enumeration items = stack.elements(); // 得到 stack 中的枚举对象 
                while (items.hasMoreElements()) //显示枚举（stack ） 中的所有元素
                    System.out.print(items.nextElement()+" ");
            }
        System.out.println(); //换行
    }
    
}  
