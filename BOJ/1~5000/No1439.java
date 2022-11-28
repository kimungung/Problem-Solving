import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 1439번 뒤집기
문자열 | 그리디

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char c = str.charAt(0);
		int count = 0;
		
		for(int i=1; i<str.length(); i++) {
			char a = str.charAt(i);
			
			if(c != a) {
				count++;
				c = a;
			}
			
		}

		
		System.out.print((count%2 == 1 ? 1:0) +count>>1);
		
	}

}
