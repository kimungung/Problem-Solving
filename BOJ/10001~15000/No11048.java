import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 11048번 이동하기
DP
bottom-up 방식이 더 간단하다.

*/

public class Main {

	static int n;
	static int m;
	static int[][] arr;
	static int answer;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 2][m + 2];
		dp = new int[n + 2][m + 2];
		answer = 0;

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i <= n + 1; i++) {
			Arrays.fill(dp[i], -1);
		}

		dp(n, m);

		System.out.print(dp[n][m]);

	}

	static int dp(int x, int y) {

		if (x == 1 && y == 1) {
			return arr[1][1];
		} else if (dp[x][y] != -1) {
			return dp[x][y];
		} else if (x < 1 || x > n || y < 1 || y > m) {
			return 0;
		} else {
			int a = dp(x - 1, y);
			int b = dp(x, y - 1);
			int c = dp(x - 1, y - 1);

			if (a >= b && a >= c && x > 1) {
				return dp[x][y] = dp(x - 1, y) + arr[x][y];
			} else if (b >= a && b >= c && y > 1) {
				return dp[x][y] = dp(x, y - 1) + arr[x][y];
			} else if (c >= a && c >= b && y > 1 && x > 1) {
				return dp[x][y] = dp(x - 1, y - 1) + arr[x][y];
			}else
				return dp[x][y] = 0;

		}

	}


}
