import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 11057번 오르막 수
DP
*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		
		for(int i=0; i<10; i++)
			dp[1][i] = 1;
		

		for(int i=2; i<=n; i++) {
			dp[i][0] = 1;
			
			for(int j=1; j<10; j++) {
				dp[i][j] = (dp[i][j-1]+dp[i-1][j])%10007; 
			}
		
		}
		
		
		int answer = 0;
		
		for(int i=0; i<10; i++) {
			answer += dp[n][i];
		}
		
		
		System.out.print(answer%10007);
		
	}

	
}
