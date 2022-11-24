import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
BOJ 3036번 링
수학 | 정수론
유클리드 호제법을 이용하면 더 빠르다.

*/


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		while(--N > 0) {
			int a = r;
			int b = Integer.parseInt(st.nextToken());
			int min = a>b ? a : b;
			int gcd = 1;
			
			for(int i=min; i>1; i--) {
				if(a%i == 0 && b%i == 0) {
					gcd = i; break;
				}
			}
			
			a /= gcd;
			b /= gcd;
			
			sb.append(a+"/"+b).append('\n');
			
		}
		
		System.out.print(sb);
		
	}

}
