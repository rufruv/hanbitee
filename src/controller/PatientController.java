package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DispatcherServlet;
import util.Separator;

@WebServlet("/patient.do")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			       throws ServletException, IOException {
		
		Separator.init(request, response);
		switch(Separator.command.getAction()){
		case "move":DispatcherServlet.send(request, response);break;
		default:
			break;
		}
		
	}
	protected String[] getAction(String path) throws ServletException, IOException{
		String[] action = new String[3];
		String[] arr = path.split("\\.");
		String[] arr2 = arr[0].split("/");
		
		action[0] = "/WEB-INF/jsp/"+arr2[1]+"/"; 
		action[1] = arr2[2];  
		action[2] = ".jsp";
		
		return action;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
