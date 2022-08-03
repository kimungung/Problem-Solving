import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 1149번 RGB거리
DP 
Top-down 방식으로 풀었다.

*/

public class Main {

	static int[][] arr;
	static int[][] cost; //최소 비용, 칠한 집 색깔

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		cost = new int[n][3];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<3; j++) 
				arr[i][j] = Integer.parseInt(st.nextToken());
			
		}

		
		System.out.print(Math.min(Math.min(cost(n-1, 0), cost(n-1,1)), cost(n-1,2)));
		

	}
	
	
	static int cost(int num, int color) {
		
		if(num == 0) {
			return arr[0][color];
		}else if(cost[num][color] != 0) {
			return cost[num][color];
		}else {
			
			if(color == 0) {
				return cost[num][0] = arr[num][0]+Math.min(cost(num-1,1), cost(num-1,2));
			}else if(color == 1) {
				return cost[num][1] = arr[num][1]+Math.min(cost(num-1,0), cost(num-1,2));
			}else {
				return cost[num][2] = arr[num][2]+Math.min(cost(num-1,0), cost(num-1,1));
			}
			
		}
		
	}

}
