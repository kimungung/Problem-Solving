import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
BOJ 1937번 욕심쟁이 판다
그래프 이론, 탐색, DFS, DP 문제.
사용한 방법보다 DFS와 DP 방식을 이용하는 것이 속도면에서 더 효율적이다.

*/

public class Main {

	static int n;
	static int[][] arr;
	static PriorityQueue<Point> q;
	static int answer;
	static int[] xPos = {-1, 1, 0, 0};
	static int[] yPos = {0, 0, -1, 1};

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		q = new PriorityQueue<>();
		answer = 0;
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				arr[i][j] = num;
				q.add(new Point(i,j,num,0));
			}
			
		}
		
		search();
		
		System.out.print(answer+1);
		
	}
	
	
	static void search() {
		int[][] check = new int[n][n];
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int count = p.count;
			
			if(check[p.x][p.y] > count) continue;
			
			answer = Math.max(count, answer);
			
			for(int i=0; i<4; i++) {
				int a = p.x+xPos[i];
				int b = p.y+yPos[i];
				
				if(a<0 || a>=n || b<0 || b>=n) continue;
				
				if(check[a][b] <= count && arr[a][b] > p.value){
					q.add(new Point(a,b, arr[a][b], count+1));
					check[a][b] = count+1;
				}

			}

		}	
		
	}
	

}


class Point implements Comparable<Point>{
	
	int x;
	int y;
	int value;
	int count;
	
	Point(int x, int y, int value, int count){
		this.x = x;
		this.y = y;
		this.value = value;
		this.count = count;
	}
	
	public int compareTo(Point p) {
		
		if(p.count != this.count)
			return p.count - this.count;
		else
			return this.value - p.value;
		
	}
	
	
}
