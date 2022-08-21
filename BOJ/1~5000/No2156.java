import java.io.*;

/*
BOJ 2156번 포도주 시식
DP

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+3];
		int[] dp = new int[n+3];
		int answer = 0;
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		dp[0] = arr[0];
		dp[1] = arr[0]+arr[1];
		dp[2] = Math.max(arr[0], arr[1])+arr[2];
		dp[3] = Math.max(dp[1], dp[0]+Math.max(arr[2], arr[1]))+arr[3];
		answer = Math.max(dp[2], dp[3]);
		
		for(int i=4; i<n; i++) {			
			dp[i] = Math.max(dp[i-2],(dp[i-4]+Math.max(arr[i-1], arr[i-2])));
			dp[i] = Math.max(dp[i], dp[i-3]+arr[i-1])+arr[i];
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.print(answer);

	}


}
