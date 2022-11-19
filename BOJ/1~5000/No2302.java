import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 2302번 극장 좌석
DP

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] dp = new int[num + 1];
		int answer = 1;

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= num; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int count = Integer.parseInt(br.readLine());
		int n = 0;

		for (int i = 0; i < count; i++) {
			int sheet = Integer.parseInt(br.readLine());
			answer *= dp[sheet - n -1];
			n = sheet;
		}

		answer *= dp[num-n];
		
		System.out.print(answer);

	}

}
