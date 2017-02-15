package util;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Clock {
	public String now(){
		/*String s="";
		SimpleDateFormat sdf = new SimpleDateFormat("year년 MM월 dd일 hh : mm : ss");
		s=new SimpleDateFormat("year년 MM월 dd일 hh : mm : ss").format(new Date());*/
		return new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss").format(new Date());
	}
}
