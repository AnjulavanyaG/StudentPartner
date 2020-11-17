package miniProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class materialsServlet extends HttpServlet{
	
public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
	String id=req.getParameter("courseId");
	String sem=req.getParameter("sem");
	String name=req.getParameter("courseName");
	//res.getWriter().println("you are in IT 1st semester");
    if(id.equalsIgnoreCase("18fd03")||name.equalsIgnoreCase("Operating Systems")||name.equalsIgnoreCase("Operating System")){	
    	RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/os.html");
    	reqDispatcher.forward(req,res);	
    }
    if(id.equalsIgnoreCase("18pd15")||name.equalsIgnoreCase("Data Communication and computer networkss")){	
    	RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/dccn.html");
    	reqDispatcher.forward(req,res);
    }
    if(id.equalsIgnoreCase("18fd09")||name.equalsIgnoreCase("Operating Systems")||name.equalsIgnoreCase("Operating System")){	
    	RequestDispatcher reqDispatcher =  getServletConfig().getServletContext().getRequestDispatcher("/os.html");
    	reqDispatcher.forward(req,res);
}
}
}
