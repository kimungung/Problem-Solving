import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 11724번 연결 요소의 개수
DFS | BFS | 연결 요소 개수
Union-Find 방식으로 찾는 방법도 있다. 그래프 탐색의 기초.

*/

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static boolean[] flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		flag = new boolean[N+1];
		int answer = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		for(int i=1; i<=N; i++) {
			
			if(!flag[i]) {
				answer++;
				dfs(i);
			}

		}
		
		System.out.print(answer);

	}
	
	
	static void dfs(int a) {
		
		if(flag[a]) return;
		
		flag[a] = true;
		
		for(int i=1; i<=N; i++) {
			if(!flag[i] && map[a][i] != 0)
				dfs(i);
		}
		
	}

}
