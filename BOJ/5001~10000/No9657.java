import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 9657번 돌 게임(3)
DP
비슷한 유형의 문제가 여럿 있다. 일정한 규칙이 있음을 이용.

*/

public class Main {

	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[1001];
		//상근이가 이기면 1, 창영이가 이기면 2
		dp[1] = 1; 
		dp[2] = 2; 
		dp[3] = 1; 
		dp[4] = 1; 
		

		if(check(n) == 1)
			System.out.println("SK");
		else
			System.out.println("CY");
		
	}

	
	static int check(int n) {
		
		if(dp[n] != 0)
			return dp[n];
		else {
			if(check(n-1) == 2 || check(n-3) == 2 || check(n-4) == 2)
				return dp[n]=1;
			else
				return dp[n]=2;
		}

	}
	
}
