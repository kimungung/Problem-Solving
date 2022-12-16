import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 12865번 평범한 배낭
DP | 0-1 배낭 문제

*/

public class Main {

	static int N;
	static int K;
	static int[][] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][2];
		int[][] dp = new int[N+1][K+1];
		//아이템, 특정 무게
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1; i<=N; i++) {
			
			for(int j=1; j<=K; j++) {
				dp[i][j] = dp[i-1][j];
				
				if(j - arr[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][0]]+arr[i][1]);
				}
				
			}
			
			
		}
		
		//모든 아이템을 고려+수용 가능 무게가 K일 때가 최댓값
		System.out.print(dp[N][K]);
	
	}


}
