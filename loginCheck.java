package miniProject;

import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginCheck extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Connection con;
	private static Statement st;
    private static ResultSet rs;
	private static String temail;
	private static String tpwd;
	private static String uemail;
	private static String upwd;
	private static int emailcheck;
	
public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
  
	 uemail=req.getParameter("Semail");
	 upwd=req.getParameter("Spassword");
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/lav","root","anju lavanya");			 
			 st=con.createStatement();
			 PreparedStatement pst = con.prepareStatement("select count(email) from test where email=?");
			 pst.setString(1, uemail);
			 rs=pst.executeQuery();
			 while(rs.next()){
				 emailcheck=rs.getInt(1);
			 if(emailcheck==1){
				 pst = con.prepareStatement("select pwd from test where email=?");
				 pst.setString(1, uemail);
				 rs=pst.executeQuery();
				 while(rs.next()){
					 if(upwd.equals(rs.getString(1))){
				 RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/page2.html");
			    	reqDispatcher.forward(req,res);	  
					 }
					 else{
						 RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/wrongcredentials.html");
					    	reqDispatcher.forward(req,res);	   				 
					 }
			 }
			 }
			 else if(emailcheck==0){
				 RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/wrongcredentials.html");
			    	reqDispatcher.forward(req,res);	   
			 }
			 }
        }
        catch(Exception e){
        	System.out.print(e);
        }
}
}
			 
				 
				 
					 
			 
