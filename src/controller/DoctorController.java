package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DispatcherServlet;
import util.Separator;

@WebServlet("/doctor.do")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		
    	Separator.init(request, response);
    	switch(Separator.command.getAction()){
    	case "move": DispatcherServlet.send(request, response);break;
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
