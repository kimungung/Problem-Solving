import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 1012번 유기농 배추
DFS | BFS | 연결 요소 개수

*/

public class Main {
	
	static int check;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N+2][M+2];
			boolean[][] flag = new boolean[N+2][M+2];
			int max = Integer.parseInt(st.nextToken());
			int answer = 0;
			
			for(int j=0; j<max; j++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())+1][Integer.parseInt(st.nextToken())+1]++;
			}
			
			for(int j=1; j<=N; j++) {
				for(int k=1; k<=M; k++) {
					check = 0;
					dfs(j,k,map,flag);
					
					if(check != 0)
						answer++;
					
				}
			}
			
			sb.append(answer).append('\n');
			
		}
		
		
		System.out.print(sb);

	}
	
	static void dfs(int a, int b, int[][] map, boolean[][] flag) {
		
		if(map[a][b] == 0 || flag[a][b]) return;
		
		check++;
		flag[a][b] = true;
		
		dfs(a-1, b, map, flag);
		dfs(a+1, b, map, flag);
		dfs(a, b-1, map, flag);
		dfs(a, b+1, map, flag);
		
	}

}
