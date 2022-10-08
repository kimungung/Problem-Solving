import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 11051번 이항계수2
DP | 이항계수 | 파스칼의 삼각형


*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] dp = new int[1001][1001];
		
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i=2; i<=n; i++) {
			
			dp[i][0] = dp[i-1][0];
			
			for(int j=1; j<=i; j++) {
				dp[i][j] = (dp[i-1][j-1]+dp[i-1][j])%10007;
			}
	
		}

		
		System.out.print(dp[n][k]);
		
	}


}
