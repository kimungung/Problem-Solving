import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BOJ 2178번 미로탐색
BFS

*/

public class Main {

	static int[][] arr;
	static int N;
	static int M;
	static boolean[][] visited;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		answer = 0;
		visited = new boolean[N][M];
	
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
			
		}
		
		bfs(0,0);
		
		System.out.print(answer);
		
	}
	
	
	static void bfs(int x, int y) {
		
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(x,y,1));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			int a = point.x;
			int b = point.y;
			int dis = point.dis;

			
			if(a == N-1 && b == M-1) {
				answer = dis;
				break;
			}
				
			
			
			if(a < N-1) {
				if(arr[a+1][b] != 0 && !visited[a+1][b]) {
					q.offer(new Point(a+1,b,dis+1));
					visited[a+1][b] = true;
				}
			}
			
			if(b < M-1) {
				if(arr[a][b+1] != 0 && !visited[a][b+1]) {
					q.offer(new Point(a,b+1,dis+1));
					visited[a][b+1] = true;
				}
			}
			
			if(a > 0) {
				if(arr[a-1][b] != 0 && !visited[a-1][b]) {
					q.offer(new Point(a-1,b,dis+1));
					visited[a-1][b] = true;
				}
			}
			
			if(b > 0) {
				if(arr[a][b-1] != 0 && !visited[a][b-1]) {
					q.offer(new Point(a,b-1,dis+1));
					visited[a][b-1] = true;
				}
			}
			
		}
		
	}

}

class Point{
	
	int x;
	int y;
	int dis;
	
	public Point(int x, int y, int dis) {
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}
