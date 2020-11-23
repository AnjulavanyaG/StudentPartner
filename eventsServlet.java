package miniProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class eventsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
	
	String event=req.getParameter("event");
	if(event.equals("symp")){
		RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/symphosium.html");
    	reqDispatcher.forward(req,res);	
	}
	if(event.equals("pool")){
		RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/pool.html");
    	reqDispatcher.forward(req,res);	
	}
	if(event.equals("contest")){
		RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/contest.html");
    	reqDispatcher.forward(req,res);	
	}
	}
}