import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 14889번 스타트와 링크
Bruteforce | 백트랙킹

*/

public class Main {

	static boolean[] check;
	static int max;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		check = new boolean[n];
		max = n >> 1;
		answer = Integer.MAX_VALUE;
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	
			}
			
		}
		
		calSum(n, 0, arr, 0);
		
		System.out.print(answer);
		
	}
	
	
	static void calSum(int n, int startN, int[][] arr, int count) {
		
		if(count == max) {
			int start = 0;
			int link = 0;
			
			for(int i=0; i<n; i++) {
				
				for(int j=i; j<n; j++) {
					
					if(check[i] && check[j]) {
						start += arr[i][j];
						start += arr[j][i];
					}else if(!(check[i] || check[j])) {
						link += arr[i][j];
						link += arr[j][i];
					}
				}
				
			}	
			
			answer = Math.min(answer, Math.abs(start-link));
			
			if(answer == 0) {
				System.out.print(0);
				System.exit(0);
			}
				
			return;
		}
		
		
		for(int i=startN; i<n; i++) {
			
			if(!check[i]) {
				check[i] = true;
				calSum(n, i, arr, count+1);
				check[i] = false;
			}
			
		}
		
		
	}

}
