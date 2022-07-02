import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 11726번 2xn 타일링 (1)
DP | 큰 수
(A+B)%C = (A%C)+(B%C) 

*/

public class Main {

	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1];
			
		System.out.print(cal(n));

	}
	
	
	static long cal(int n) {
		
		if(n == 0 || n == 1 || n == 2) return n;
		else if(dp[n] != 0) return dp[n];
		else {
			return dp[n]=((cal(n-1)+cal(n-2)))%10007;
		}
		
	}

	
	
}
