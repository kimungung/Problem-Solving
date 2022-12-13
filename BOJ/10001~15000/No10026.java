import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*
BOJ 10026번 적록색약
그래프이론 | 그래프 탐색

*/

public class Main {

	static int n;
	static char[][] arr;
	static int[] xPos = {-1, 1 , 0 , 0};
	static int[] yPos = {0, 0, -1, 1};
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		boolean[][] flagArr1 = new boolean[n][n];
		boolean[][] flagArr2 = new boolean[n][n];
		int answer1 = 0;
		int answer2 = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				
				if(!flagArr1[i][j]) {
					answer1++;
					flagArr1[i][j] = true;
					bfs(i,j,flagArr1);
				}
				
				if(!flagArr2[i][j]) {
					answer2++;
					flagArr2[i][j] = true;
					if(arr[i][j] == 'B') {
						bfs(i,j,flagArr2);
					}else {
						bfsRG(i,j,flagArr2);
					}

				}
				
			}
		}
		
		
		sb.append(answer1).append(' ');
		sb.append(answer2);
		
		System.out.print(sb);

	}
	
	
	
	static void bfs(int x, int y, boolean[][] flag) {
		LinkedList<Point> q = new LinkedList<>();
		char firstChar = arr[x][y];
		
		q.offer(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point input = q.poll();
			
			for(int i=0; i<4; i++) {
				int a = input.x - xPos[i];
				int b = input.y - yPos[i];
				
				if(a>=0 && a<n && b>=0 && b<n) {
					
					if(arr[a][b] == firstChar && !flag[a][b]) {
						q.offer(new Point(a,b));
						flag[a][b] = true;
					}

				}
				
			}
			
		}
		
		
	}


	static void bfsRG(int x, int y, boolean[][] flag) {
		LinkedList<Point> q = new LinkedList<>();
		
		q.offer(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point input = q.poll();
			
			for(int i=0; i<4; i++) {
				int a = input.x - xPos[i];
				int b = input.y - yPos[i];
				
				if(a>=0 && a<n && b>=0 && b<n) {
					
					if((arr[a][b] == 'R' || arr[a][b] == 'G') && !flag[a][b]) {
						q.offer(new Point(a,b));
						flag[a][b] = true;
					}

				}
				
			}
			
		}
		
		
	}
	
}


class Point{
	
	int x;
	int y;
	
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}
