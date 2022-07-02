import java.io.*;

/*
BOJ 11727번 2xn 타일링(2)
DP | 큰 수 | 점화식
점화식 도출을 잘 할 필요가 있다.
*/

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 3;
		dp[3] = 5;		
		
		for(int i=4; i<n+1; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		
		System.out.print(dp[n]);
		
	}
	
}
