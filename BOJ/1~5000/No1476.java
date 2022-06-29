import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 1476번 날짜 계산
수학 / BruteForce
단순 계산한다.
연산 속도가 조금 더 빠른 쪽을 주석 처리 해둔 상태.

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int e = Integer.parseInt(str[0]);
		int s = Integer.parseInt(str[1]);
		int m = Integer.parseInt(str[2]);
		int answer = 1;
		int a = 1, b = 1, c = 1;
		
		if( e == s && e == m) {
			answer = e;
		}else {
			while(e != a || s != b || m != c) {
				a++; b++; c++;
				answer++;

			/* 더 빠르다!
				if(a == 16)
					a = 1;
				if(b == 29)
					b = 1;
				if(c == 20)
					c = 1;				
			*/

				a = (a == 16) ? 1 : a;
				b = (b == 29) ? 1 : b;
				c = (c == 20) ? 1 : c;

			}
		}
			
		System.out.println(answer);
		
	}
	

}
