package domain;

import handler.CommandHandler;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data public class Command implements CommandHandler{
	@Getter @Setter
	private String directory, action, page;
	@Getter
	private String view;
	public Command(String directory, String action, String page){
		this.directory = directory;
		this.action = action;
		this.page = page;
		this.setView();
	}
	
	public void setView(){
		System.out.println("VIEW : "+"/WEB-INF/jsp" + this.directory+"/"+this.page+".jsp");
		this.view=(directory.equals("/home"))?"/WEB-INF/jsp/common/"+this.page+".jsp"
											 :"/WEB-INF/jsp" + this.directory+"/"+this.page+".jsp";

	}
	
	@Override
	public String process() {
		return null;
	}



}
