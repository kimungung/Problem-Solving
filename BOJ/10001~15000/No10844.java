import java.io.*;

/*
BOJ 10844번 쉬운 계단 수
DP

*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dp = new long[N+2][10];
		int answer=0;
		
		for(int i=1; i<10; i++)
			dp[1][i] = 1;
		
		for(int i=2; i<=N; i++) {
			
			for(int j=0; j<10; j++) {
				
				if(j == 0) {
					dp[i][0] = dp[i-1][1];
				}else if(j == 9){
					dp[i][9] = dp[i-1][8];
				}else{
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
				}
				
			}
		}
		
		for(int i=0; i<10; i++) {
			answer += dp[N][i];
			answer %= 1000000000;
		}
		
		
		System.out.print(answer);

	}
	
	

}
