package util;

public class Ssn {
	public String getSsn(String name, String ssn){
		String gender = "";
		char ch = ssn.charAt(7);
		if (ch == '0' || ch == '7' || ch == '8' || ch == '9') {
			gender = "다시 입력하세요";
		}
		if (ch == '1' || ch == '3') {
			gender = "남자";
		} else if (ch == '2' || ch == '4') {
			gender = "여자";
		} else {
			gender = "외국인";
		}
		return gender;
	}
}
