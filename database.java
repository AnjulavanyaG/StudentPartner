package miniProject;

import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class database extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Connection con;
	private static Statement st;
	//private static ResultSet rs;
	private static String name;
	private static String email;
	private static String dept;
	private static String sem;
	private static String pwd;
	
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
  
	 name=req.getParameter("Sname");
	 email=req.getParameter("Semail");
         dept=req.getParameter("Sdept");
	 sem=req.getParameter("Ssem");
        pwd=req.getParameter("Spassword");
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/lav","root","anju lavanya");
        	
           DatabaseMetaData dbm=con.getMetaData();
    		ResultSet tables=dbm.getTables(null,null,"test",null);
    		
    		if(tables.next()){
    			PreparedStatement pst = con.prepareStatement("insert into test values(?,?,?,?,?)");
    			pst.setString(1, name);
    			pst.setString(2,email);
    			pst.setString(3, dept);
    			pst.setString(4, sem);
    			pst.setString(5, pwd);
    			pst.execute();
    		}
    		else{
    			st = con.createStatement();
    			 st.execute("create table test(name varchar(30), email varchar(30), dept varchar(30), sem varchar(1),pwd varchar(18))");
    			 PreparedStatement pst = con.prepareStatement("insert into test values(?,?,?,?,?)");
     			pst.setString(1, name);
     			pst.setString(2,email);
     			pst.setString(3, dept);
     			pst.setString(4, sem);
     			pst.setString(5, pwd);
     			pst.execute();
    		}
    	 }
        catch(Exception e){System.out.println(e);
        }
		
        RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/page2.html");
    	reqDispatcher.forward(req,res);	   
}
/*public static void display() throws Exception {
	 st = con.createStatement();
	 rs=st.executeQuery("select * from students;");
	 while(rs.next()){
			 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
		 
	 }
 }*/
}