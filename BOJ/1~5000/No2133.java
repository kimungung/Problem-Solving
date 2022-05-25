import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

2133번
DP를 활용한 문제
점화식 도출이 중요하다.

*/

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[31];
		
		dp[2] = 3;
		
		if(n%2 == 1) {
			System.out.print(0); return;
		}
		
		for(int i=4; i<=n; i+=2) {
			dp[i] = dp[i-2]*3+2;
			
			for(int j=i-4; j>0; j-=2) {
				dp[i] += dp[j]*2;
			}
			
		}
		
		
		System.out.print(dp[n]);

	}
	

	
}
