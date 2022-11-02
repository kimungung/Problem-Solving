import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 1309번 동물원
DP
점화식을 더 간단히 할 수도 있다.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][2];
		
		dp[1][0] = 1;
		dp[1][1] = 2;
		
		
		for(int i=2; i<=n; i++) {
			dp[i][0]= (dp[i-1][0]+dp[i-1][1])%9901;
			dp[i][1]= (dp[i-1][0]*2+dp[i-1][1])%9901;
		}
		
		System.out.print((dp[n][0]+dp[n][1])%9901);

	}
	

}
