import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BOJ 1260번 DFS와 BFS
DFS | BFS

*/

public class Main {

	static int[][] arr;
	static int n;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		dfs(start);
		sb.append('\n');
		Arrays.fill(visited, false);
		bfs(start);
		
		System.out.print(sb);
		
	}
	
	
	static void dfs(int start) {
		

		sb.append(start).append(' ');
		visited[start] = true;
		
		for(int i=1; i<=n; i++) {
			if(arr[start][i] != 0 && !visited[i]) {
				dfs(i);
			}
		}
		
	}
	
	
	static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int a = q.poll();
			
			sb.append(a).append(' ');
			
			for(int i=1; i<=n; i++) {
				
				if(arr[a][i] != 0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
				
			}
			
			
		}
		
	}

}
