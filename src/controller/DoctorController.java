package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/doctor/main.do","/doctor/detail.do"})
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		
    	String[] action = getAction(request.getServletPath());
		switch(action[1]){
		case "main":
			request.getRequestDispatcher(action[0] + action[1] + action[2])
			       .forward(request, response);
			break;
		case "detail":
			request.getRequestDispatcher(action[0] + action[1] + action[2])
		       	   .forward(request, response);
			break;
		default:break;
		}
	}

	protected String[] getAction (String path){
		String[] action = new String[3];

		action[0] = "/WEB-INF/jsp/"+path.split("\\.")[0].split("/")[1]+"/";
		action[1] = path.split("\\.")[0].split("/")[2];
		action[2] = ".jsp";
		return action;
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
