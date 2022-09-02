import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 11722번 가장 긴 감소하는 부분 수열
DP | Binary Search
11053번과 유사하다.

*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int max = 1;
		
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = 1;
		
		for(int i=1; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i] < arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}			
			
			max = Math.max(max,dp[i]);
		}
			
		System.out.print(max);
		
	}


}
