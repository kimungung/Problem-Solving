import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 2033번 반올림
수학 | 구현
조금 더 단순하게 하는 방법이 있다.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num = Integer.parseInt(str);
		
		for(int i=1; i<str.length(); i++) {
			int n = (int)(num%Math.pow(10, i));
		
			if(n >= 5*Math.pow(10, i-1)) {
				num += Math.pow(10, i) - n;
			}else {
				num -= n;
			}
		}
		
		System.out.print(num);
		
	}

}
