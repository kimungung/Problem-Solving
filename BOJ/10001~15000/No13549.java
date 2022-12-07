import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 13549번 숨바꼭질3
BFS | 다익스트라 | 0-1 너비 우선 탐색

*/

public class Main {

	static int N;
	static int K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int answer = 0;
		int[] visited = new int[N > K ? N + 1 : K + 2];


		if(N < K) {
			bfs(visited);
			answer = visited[K];
		}else {
			answer = N-K;
		}
		

		System.out.print(answer);

	}

	static void bfs(int[] visited) {

		LinkedList<Integer> q = new LinkedList<>();
		int max = visited.length;

		Arrays.fill(visited, 100000);
		visited[N] = 0;
		q.offer(N);

		while (!q.isEmpty()) {			
				int p = q.poll();
				
				if(p == K) {	
					break;
				}
				
				
				if(p*2 < max && visited[p] <= visited[p*2] ){
					visited[p*2] = visited[p];
					q.offer(p*2);
				}
				
				if(p+1 < max && visited[p] < visited[p+1]){
					visited[p+1] = visited[p]+1;
					q.offer(p+1);			
				}
				
				if(p > 0 && visited[p] < visited[p-1]){
					visited[p-1] = visited[p]+1;
					q.offer(p-1);			
				}
			}
			

	}

}
