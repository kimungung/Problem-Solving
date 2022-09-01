import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 11055번 가장 큰 증가 부분 수열
DP

*/


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		int max;
		
		
		for(int i=1; i<=n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		
		dp[1] = arr[1];
		max = dp[1];
		
		for(int i=2; i<=n; i++) {
			for(int j=i-1; j>0; j--) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+arr[i]);
				}
			}
			
			if(dp[i] == 0)
				dp[i] = arr[i];
			
			max = Math.max(max,dp[i]);
		}
			
		System.out.print(max);
		
	}

}
