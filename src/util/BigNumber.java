package util;

public class BigNumber {
	public String getBigNumber(int a, int b, int c) {
		String result = "";
		if (a > b && a > c) {
			if (b > c) {
				result = String.format("%d -> %d -> %d", a,b,c); 
			} else {
				result = String.format("%d -> %d -> %d", a,c,b);
			}
		} else if (b > a && b > c) {
			if (a > c) {
				result = String.format("%d -> %d -> %d", b,a,c);
			} else {
				result = String.format("%d -> %d -> %d", b,c,a);
			}
			
		} else if (c > a && c > b) {
			if (a > b) {
				result = String.format("%d -> %d -> %d", c,a,b);
			} else {
				result = String.format("%d -> %d -> %d", c,b,a);
			}
		}
		return result;
	}
}