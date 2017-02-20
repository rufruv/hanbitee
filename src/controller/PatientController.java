package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/patient/loginForm.do","/patient/registerForm.do"})
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("=========서블릿 진입 성공=========");*/
		/*RequestDispatcher rd = null;*/
		/*String path = request.getServletPath();
		System.out.println("리퀘스트개체가 걸어온길"+path);*/
		String action[] = getAction(request.getServletPath());
		switch(action[1]){
		case "loginForm"  :
			/*rd = request.getRequestDispatcher("/WEB-INF/jsp/customer/patLoginForm.jsp");*/
			request.getRequestDispatcher(action[0] + action[1] + action[2])
			.forward(request, response);
			break;
		case "registerForm" :
			/*rd = request.getRequestDispatcher("/WEB-INF/jsp/customer/patRegisterForm.jsp");*/
			request.getRequestDispatcher(action[0] + action[1] + action[2])
			.forward(request, response);
			break;
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
