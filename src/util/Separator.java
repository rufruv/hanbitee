package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import factory.CommandFactory;

public class Separator {
	public static Command command;
	public static void init(HttpServletRequest request, 
						    HttpServletResponse response){
		String path=request.getServletPath();
		System.out.println("==="+path); //===/patient.do 
		String directory = path.substring(0, path.indexOf("."));
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		String pageNO = request.getParameter("pageNO");
		System.out.println("Separator PATH: "+ path);
		System.out.println("Separator DIR: "+ directory);
		System.out.println("Separator ACTION: "+ action);
		System.out.println("Separator PAGE: "+ page);
		System.out.println("Separator PAGE_NO: "+ pageNO);
		if(pageNO==null){
			command = CommandFactory.createCommand(directory, action, page);
		}else{
			command = CommandFactory.createCommand(directory, action, page, pageNO);
		}
		
	}
}
