import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
BOJ 7562번 나이트의 이동
BFS

*/

public class Main {

	static int len;
	static StringBuilder sb;
	static int[] arrX = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] arrY = {-2, -1, 1, 2, -2, -1, 1, 2};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		sb = new StringBuilder();
		
		
		for(int i=0; i<n; i++) {
			len = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Point p = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			Point goal = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			
			bfs(p, goal);
			
		}
		
		
		System.out.print(sb);
		
	}
	
	
	static void bfs(Point p, Point goal) {
		Queue<Point> arr = new LinkedList<>();
		boolean[][] flag = new boolean[len][len];
		int goalX = goal.getX();
		int goalY = goal.getY();
		int answer = 0;
		
		arr.offer(p);
		
		while(!arr.isEmpty()) {
			int qLen = arr.size();
			
			for(int i=0; i<qLen; i++) {
				Point p1 = arr.poll();
				int x = p1.getX();
				int y = p1.getY();

				
				if(x == goalX && y == goalY) {
					sb.append(answer).append('\n');
					return;
				}
				
				for(int j=0; j<8; j++) {
					int a = x+arrX[j];
					int b = y+arrY[j];
					
					if(a>=0 && a<len && b>=0 && b<len) {
						if(!flag[a][b]) {
							flag[a][b] = true;
							arr.offer(new Point(a,b));
						}

					}
				}
				
				
			}

			answer++;
			
		}

		
	}


}





class Point{
	
	int x;
	int y;
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}

	
}
