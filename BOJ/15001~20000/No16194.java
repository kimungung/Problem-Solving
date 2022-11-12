import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 16194번 카드 구매하기2
DP

*/

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			
			dp[i] = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<=i; j++) {
				dp[i] = Math.min(dp[j]+dp[i-j],dp[i]);
			}
			
		}
		
		System.out.print(dp[n])

	}

}
