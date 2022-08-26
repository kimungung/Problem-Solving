import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 9184번 신나는 함수 실행
DP | 재귀
Bottom-up 방식이 더 빠르다.
*/

public class Main {

	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new int[21][21][21];
		StringBuilder str1 = new StringBuilder("w(");
		StringBuilder str2 = new StringBuilder(", ");
		StringBuilder str3 = new StringBuilder(") = ");
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if( a == -1 && b == -1 && c == -1)
				break;
			
			int answer = calW(a,b,c);
			
			sb.append(str1).append(a);
			sb.append(str2).append(b);
			sb.append(str2).append(c);
			sb.append(str3);
			sb.append(answer).append('\n');
		}
		
		System.out.print(sb);
		
	}

	
	static int calW(int a, int b, int c) {
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a > 20 || b > 20 || c > 20) {
			if(dp[20][20][20] != 0)
				return dp[20][20][20];
			else
				return dp[20][20][20] = calW(20,20,20);
		}
		
		if(dp[a][b][c] != 0) {
			return dp[a][b][c];
		}else {
			
			if(a < b && b < c) {
				
				return dp[a][b][c] = calW(a,b,c-1)+calW(a,b-1,c-1)-calW(a,b-1,c);
				
			}else {
				
				return dp[a][b][c] = calW(a-1,b,c)+calW(a-1,b-1,c)+calW(a-1,b,c-1)-calW(a-1,b-1,c-1);
			}
			
		}
		
		
	}


}
