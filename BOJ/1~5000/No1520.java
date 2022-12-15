import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 1520번 내리막길
DP | dfs

*/

public class Main {

	static int[][] arr;
	static int m;
	static int n;
	static int goal;
	static int[] xPos = { -1, 1, 0, 0 };
	static int[] yPos = { 0, 0, -1, 1 };
	static int[][] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		dp = new int[m][n];
		int answer = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}

		}

		goal = arr[m - 1][n - 1];

		answer = dfs(0, 0);
		

		System.out.print(answer);

	}

	static int dfs(int x, int y) {

		if (x == m - 1 && y == n - 1) {
			return 1;
		}
		
		
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		

		dp[x][y] = 0;
		
		for (int i = 0; i < 4; i++) {
			int a = x + xPos[i];
			int b = y + yPos[i];

			if (a < 0 || a >= m || b < 0 || b >= n)
				continue;

			int v = arr[a][b];

			if (arr[x][y] > v && v >= goal ){
				dp[x][y] += dfs(a, b);
			}

		}
		
		return dp[x][y];

	}

}
