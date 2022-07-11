import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 8595번 히든넘버
문자열 | 파싱
더 단순한 방법이 있다.

*/

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringBuilder num = new StringBuilder();
		long sum = 0;
		
		for(int i=0; i<N; i++) {
			char c = str.charAt(i);
			
			if(Character.isDigit(c)) {
				num.append(c);
			}else {
				
				if(num.length() != 0) {
					sum += Integer.parseInt(num.toString());
				}

				num = new StringBuilder();
			}
			
		}
		
		if(num.length() != 0) {
			sum += Integer.parseInt(num.toString());
		}
		
		System.out.print(sum);
		
	}

}
