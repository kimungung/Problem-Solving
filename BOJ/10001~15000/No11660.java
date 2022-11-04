import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 11660번 구간 합 구하기5 
dp | 누적합

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[][] map = new int[n+1][n+1]; //n+1사이즈로 만드는 것이 용이
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<=n; j++) {				
				map[i][j] = map[i-1][j]+map[i][j-1]-map[i-1][j-1]+ Integer.parseInt(st.nextToken());
			}
		}
		
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int answer = map[x2][y2]-map[x1-1][y2]-map[x2][y1-1]+map[x1-1][y1-1];
			
			sb.append(answer).append('\n');

		}
		
		
		System.out.print(sb);
		
	}

	
}
