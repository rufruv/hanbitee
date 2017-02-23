package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.MembershipService;

import domain.PatientBean;
import service.PatientService;
import serviceImpl.PatientServiceImpl;
import util.DispatcherServlet;
import util.Separator;

@WebServlet("/patient.do")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			       throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		PatientService service = PatientServiceImpl.getInstance();
		PatientBean bean = new PatientBean();
		Separator.init(request, response);
		switch(Separator.command.getAction()){
		case "move":DispatcherServlet.send(request, response);break;
		case "mypage":
			String birth = service.getBirth(service.getSession().getPatJumin());
			System.out.println("생년월일: "+birth);
			request.setAttribute("birth", birth);
			System.out.println("SET완료!");
			String age = service.getAge(service.getSession().getPatJumin());
			System.out.println("나이: "+age);
			request.setAttribute("age", age);
			System.out.println("SET완료!");
			DispatcherServlet.send(request, response);
			break;
		case "login":
			String pw = request.getParameter("password");
			bean.setPatID(request.getParameter("id"));
			try {
				PatientBean temp = service.login(bean);
				System.out.println("DB 다녀온 후 아이디: "+temp.getPatID());
				System.out.println("DB 다녀온 후 비번: "+temp.getPatPass());
				if(!temp.getPatID().equals("FAIL") && temp.getPatPass().equals(pw)){
					System.out.println("===로그인 성공===");
					session.setAttribute("user", temp);
					DispatcherServlet.send(request, response);
				}
				else{
					System.out.println("===아이디가 없어서 로그인 실패===");
					Separator.command.setPage("loginForm");
					System.out.println("가는 페이지"+Separator.command.getPage());
					Separator.command.setView();
					DispatcherServlet.send(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
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
