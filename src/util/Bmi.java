package util;

public class Bmi {
	public String getBmi(double weight, double height) {
		String grade = ""; 
		double bmi = weight / (height/100 * height/100);
		if (bmi > 30.0) {
			grade = "고도비만";
		} else if (bmi > 25.0) {
			grade = "비만";
		} else if (bmi > 23.0) {
			grade = "과체중";
		} else if (bmi > 18.5) {
			grade = "정상";
		} else {
			grade = "저체중";
		}
		return grade;
	}
}