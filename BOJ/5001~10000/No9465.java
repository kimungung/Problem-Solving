import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 9465번 
DP

*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(n-- != 0) {
			int len = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][len+1];
			int[][] dp = new int[2][len+1];
			int answer = 0;
			
			for(int i=0; i<2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<len; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			
			dp[0][1] = arr[0][1]+arr[1][0];
			dp[1][1] = arr[1][1]+arr[0][0];
			
			
			for(int i=2; i<len; i++) {
				int bigger = Math.max(dp[0][i-2], dp[1][i-2]);
				
				dp[0][i] = arr[0][i]+Math.max(dp[1][i-1], bigger);
				dp[1][i] = arr[1][i]+Math.max(dp[0][i-1], bigger);
				
			}
			
			
			answer = Math.max(dp[0][len-1], dp[1][len-1]);
			
			sb.append(answer).append('\n');
			
		}
		
		
		System.out.print(sb);
		
	}

	
}
