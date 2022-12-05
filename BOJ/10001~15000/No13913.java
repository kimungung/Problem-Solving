import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 13913번 숨바꼭질4
BFS

*/

public class Main {

	static int N;
	static int K;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		int[] visited = new int[N > K ? N + 1 : K + 2];


		if(N < K) {
			bfs(visited);
		}else {

			sb.append(N-K).append('\n');
			for(int i=N; i>=K; i--) {
				sb.append(i).append(' ');
			}
		}
		

		System.out.print(sb);

	}

	static void bfs(int[] visited) {

		LinkedList<Point> q = new LinkedList<>();
		int max = visited.length;

		visited[N] = 1;
		q.offer(new Point(N,0));

		while (!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == K) {
				sb.append(p.dis).append('\n');
				
				for(int i=0; i<p.getSize(); i++)
					sb.append(p.getValue(i)).append(' ');
				
				return;
			}
			
			
			if(p.x*2 < max && (visited[p.x*2] == 0 || p.dis < visited[p.x*2])){
				Point nextP = new Point(p.x*2, p.dis+1, p.arr);
				visited[nextP.x] = nextP.dis;
				q.offer(nextP);
			}
			
			if(p.x+1 < max && (visited[p.x+1] == 0 || p.dis < visited[p.x+1])){
				Point nextP = new Point(p.x+1, p.dis+1, p.arr);
				visited[nextP.x] = nextP.dis;
				q.offer(nextP);				
			}
			
			if(p.x > 0 && (visited[p.x-1] == 0 || p.dis < visited[p.x-1])){
				Point nextP = new Point(p.x-1, p.dis+1,  p.arr);
				visited[nextP.x] = nextP.dis;
				q.offer(nextP);				
			}

		}
		

	}

}



class Point{
	
	int x;
	int dis;
	ArrayList<Integer> arr = new ArrayList<>();
	
	Point(int x, int dis){
		this.x = x;
		this.dis = dis;
		arr.add(x);
	}
	
	Point(int x, int dis, ArrayList<Integer> input){
		this.x = x;
		this.dis = dis;
		copyArr(input);
		this.arr.add(x);
	}
	
	void copyArr(ArrayList<Integer> input) {
		
		for(int i=0; i<input.size(); i++)
			this.arr.add(input.get(i));
		
	}
	
	
	public int getSize() {
		return arr.size();
	}
	
	public int getValue(int i) {
		return arr.get(i);
	}
	
}
