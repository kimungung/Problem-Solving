import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 2206번 벽 부수고 이동하기
BFS

*/

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int answer;
	static int[] xPos = {-1, 1, 0, 0};
	static int[] yPos = {0, 0, -1, 1};
	

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		answer = -1;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
			
		}
		
		if(N == 1 && M == 1) {
			System.out.print(1); return;
		}
		
		bfs();
		
		System.out.print(answer);

	}
	
	
	static void bfs() {
		LinkedList<Point> q = new LinkedList<>();
		int count = 0;
		int[][] flag = new int[N][M];  // 0: 미방문, 1: 방문, 2: 벽 안 부순 루트 방문
		
		q.offer(new Point(0,0));
		flag[0][0] = 2;
		
		while(!q.isEmpty()) {
			int leng = q.size();
			
			count++;
			
			for(int i=0; i<leng; i++) {
				Point p = q.poll();

				for(int j=0; j<4; j++) {
					int a = p.x+xPos[j];
					int b = p.y+yPos[j];
					
					if(a < 0 || a >= N || b < 0 || b >= M) continue;
					
					if(a == N-1 && b == M-1) {
						answer = count+1; return;
					}
					
					if(arr[a][b] == 1) {
						
						if(!p.wall && flag[a][b] == 0) {
							q.offer(new Point(a,b,true));
							flag[a][b] = 2;
						}
						
					}else {
						
						if(flag[a][b] == 0){
							q.offer(new Point(a,b,p.wall));
							flag[a][b] = 1;
						}else {
							 if(flag[a][b] == 1 && !p.wall) {
								 q.offer(new Point(a,b,p.wall));
								 flag[a][b] = 2;
							 }
						}
						
					}
					
					
				}
				
				
			}
			
			
			
		}
		
		
	}


}


class Point{
	
	int x;
	int y;
	boolean wall;
	
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
		wall = false;
	}
	
	
	Point(int x, int y, boolean wall){
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
	
	
}
