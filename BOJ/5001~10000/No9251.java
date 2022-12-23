import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 9251번 LCS
최장 공통 부분 수열 문제


*/

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		int leng1 = str1.length;
		int leng2 = str2.length;
		int[][] dp = new int[leng1+1][leng2+1];
		
	
		for(int i=1; i<=leng1; i++) {
			
			for(int j=1; j<=leng2; j++) {
				
				if(str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
			
		}
		
		System.out.print(dp[leng1][leng2]);

	}

}
