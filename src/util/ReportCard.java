package util;

public class ReportCard {
	public String[] getGrade(int korea, int english, int math) {
		
		int total = korea + english + math;
		int average = total / 3;
		String grade = "";
		
		if(average>=90){
			grade = "A";
		}else if(average>=80){
			grade = "B";
		}else if(average>=70){
			grade = "C";
		}else{
			grade = "D";
		}
		String[] arrResult = new String[3];
		arrResult[0] = String.valueOf(total);
		arrResult[1] = String.valueOf(average);
		arrResult[2] = grade;
		
		/*return String.format("Total: %d | Average: %d | Grade: %s", total,average,grade);*/
		return arrResult;
	}
}