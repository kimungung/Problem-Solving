import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 16948번 데스 나이트
그래프 이론, 그래프 탐색, BFS

*/

public class Main {

	static int N;
	static int goalX;
	static int goalY;
	static int answer = -1;
	static int[] posX = {-2,-2,0,0,2,2};
	static int[] posY = {-1,1,-2,2,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		goalX = Integer.parseInt(st.nextToken());
		goalY = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		findAnswer(x,y);
		
		System.out.print(answer);

	}
	
	
	static void findAnswer(int x, int y) {
		boolean[][] flag = new boolean[N][N];
		LinkedList<Point> q = new LinkedList<>();
		
		q.add(new Point(x,y,0));
		flag[x][y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int a1 = p.x;
			int b1 = p.y;
			int count = p.count;
			
			if(a1 == goalX && b1 == goalY) {
				answer = count;
				return;
			}
			
			for(int i=0; i<6; i++) {
				int a2 = a1+posX[i];
				int b2 = b1+posY[i];
				
				if(a2 >= N || b2 >= N || a2 <0 || b2 <0 ) continue;
				
				if(flag[a2][b2]) continue;
				
				flag[a2][b2] = true;
				q.add(new Point(a2,b2,count+1));
				
				
			}
			
			
		}
		
		
	}


}



class Point{
	int x;
	int y;
	int count;
	
	Point(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
	
}
