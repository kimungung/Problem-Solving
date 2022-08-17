import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 1697번 숨바꼭질
BFS

*/

public class Main {

	static int N;
	static int K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] visited = new int[N>K ? N+1 : K*2+1];
		int answer = 0;
		
		answer = bfs(visited);
		
		System.out.print(answer);
		
	}
	
	
	static int bfs(int[] visited) {
		
		LinkedList<Integer> q = new LinkedList<>();
		int max = visited.length;
		
		visited[N] = 1;
		q.offer(N);
		
		while(!q.isEmpty()) {
			int point = q.poll();
						
			if(point == K) {
				return visited[point]-1;
			}

			if(point*2 < max && visited[point*2] == 0) {
				visited[point*2] = visited[point]+1;
				q.offer(point*2);
			}
			
			if(point+1 < max && visited[point+1] == 0) {
				visited[point+1] = visited[point]+1;
				q.offer(point+1);
			}
			
			if(point > 0 && visited[point-1] == 0) {
				visited[point-1] = visited[point]+1;
				q.offer(point-1);
			}
			
		}
		
		return -1;
		
	}

}
