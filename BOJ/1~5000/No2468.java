import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 2468번 안전 영역
dfs
4963번 같은 문제의 심화. 비가 전혀 내리지 않는 경우를 고려할 것.

*/

public class Main {

	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int answer = 0;
		int max = 0;
		int[][] arr = new int[n+2][n+2];
		
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=n; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j] = a;
				max = Math.max(max, a);
			}
			
		}
		
		for(int k = 1; k<=max; k++) {
			int count = 0;
			int[][] ground = new int[n+2][n+2];
			
			for(int i=1; i<=n; i++) {
				for(int j=0; j<=n; j++)
					ground[i][j] = arr[i][j];
			}
			
			
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					
					if(ground[i][j] >= k) {
						
						count++;
						dfs(ground, i, j, k);
					}	
					
				}
			}
			
			answer = Math.max(count, answer);
		}

		System.out.print(answer);
		
	}
	
	
	
	static void dfs(int[][] arr, int x, int y, int limit) {
		
		if(x>0 && x<=n && y<=n && y>0) {
			if(arr[x][y] >= limit) {
				arr[x][y] = 0;
				dfs(arr, x-1, y, limit);
				dfs(arr, x+1, y, limit);
				dfs(arr, x, y+1, limit);
				dfs(arr, x, y-1, limit);
			}
		}
		
	}


}
