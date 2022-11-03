import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 1890번 점프
DP
Top-down 방식 풀이

*/

public class Main {

	static int N;
	static int[][] arr;
	static long[][] dp;
	static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new long[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		findRoute(0, 0);

		System.out.print(dp[0][0]);

	}

	static long findRoute(int x, int y) {

		if (x >= N || y >= N)
			return 0;

		if (x == N - 1 && y == N - 1) {
			return 1;
		} else if (dp[x][y] != -1) {
			return dp[x][y];
		} else {

			if(arr[x][y] == 0)
				return dp[x][y] = 0;
			
			return dp[x][y] = findRoute(x + arr[x][y], y) + findRoute(x, y + arr[x][y]);

		}

	}

}
