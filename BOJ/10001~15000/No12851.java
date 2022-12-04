import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 12851번 숨바꼭질2
BFS

*/

public class Main {

	static int N;
	static int K;
	static int Num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] visited = new int[N > K ? N + 1 : K + 2];
		StringBuilder sb = new StringBuilder();
		Num = 1;
		int answer = 0;

		if(N < K) {
			answer = bfs(visited);
		}else {
			answer = N-K;
		}
		sb.append(answer).append('\n');
		sb.append(Num);

		System.out.print(sb);

	}

	static int bfs(int[] visited) {

		LinkedList<Integer> q = new LinkedList<>();
		int max = visited.length;
		int answer = -1;
		int count = 0;

		visited[N] = 1;
		q.offer(N);

		while (!q.isEmpty()) {
			int length = q.size();
			ArrayList<Integer> arr = new ArrayList<>();
			
		
			if(answer != -1 && answer < count+1)
				return answer;
			
			
			for(int i=0; i<length; i++) {
				int p = q.poll();

				
				if (p == K) {
					if (answer == -1) {
						answer = count;
					} else if (answer == count) {
						Num++;
					} 
				}

				
				if (p*2 < max && visited[p*2] == 0) {
					arr.add(p*2);
					q.add(p*2);
				}

				if (p+1 < max && visited[p+1] == 0) {
					arr.add(p+1);
					q.add(p+1);
				}

				if (p > 0 && visited[p-1] == 0) {
					arr.add(p-1);
					q.add(p-1);
				}
				
			}
			
			count++;
			
			for(int i=0; i<arr.size(); i++) {
				visited[arr.get(i)]++;
			}

		}

		return answer;

	}

}
