import java.io.*;

/*
BOJ 1699번 제곱수의 합
DP
처음 풀었던 방법이 유독 오래 걸려서 다른 방식을 참고해 풀었다.
상세 설명은 주석으로 표기.
*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		dp[1] = 1;

		
		for (int i = 2; i <= n; i++) {
			//1의 제곱으로 표현할 경우 최대 수는 i
			dp[i] = i;
			
			//j의 제곱이 i인 경우까지 고려해 loop
			for(int j=1; j*j <=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}

		}

		System.out.print(dp[n]);

	}

}
