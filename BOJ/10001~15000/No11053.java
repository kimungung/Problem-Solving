import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 11053번 가장 긴 증가하는 부분 수열
DP | LIS(최장 증가 부분 수열) 문제

*/

public class Main {

	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		dp = new int[n];
		int answer = 1;
		
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		
		for(int i=0; i<n; i++) {
			search(i);
		}
		
		
		for(int i=1; i<n; i++)
			answer = Math.max(answer, dp[i]);
		
		System.out.print(answer);

	}
	
	
	static int search(int a) {
		
		
		if(a == 0) {
			return 1;
		}else if(dp[a] != 0) {
			return dp[a];
		}else {
			int max = 1;
			
			for(int i=a-1; i>=0; i--) {
				if(arr[a] > arr[i])
					max = Math.max(max, search(i)+1);
			}
			
			return dp[a] = max;
		}
		
	}


}
