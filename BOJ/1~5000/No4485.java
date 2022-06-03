import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*

BOJ 4485번 녹색 옷 입은 애가 젤다지?
다익스트라 문제.
PriorityQueue를 이용한다.

*/

public class Main {

	static int N;
	static int answer;
	static int[] xPos = {-1, 1, 0, 0};
	static int[] yPos = {0, 0, -1, 1};

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int count = 1;
		StringBuilder sb = new StringBuilder();


		while (N != 0) {
			int[][] arr = new int[N][N];
			answer = Integer.MAX_VALUE;
			int[][] cost = new int[N][N];


			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
				
			}

			// 최솟값 찾는 함수 호출
			findRoute(arr,cost);
			
			sb.append("Problem ").append(count).append(": ");
			sb.append(answer);
			sb.append('\n');
			
			count++;
			N = Integer.parseInt(br.readLine());
		}
		
		
		System.out.print(sb);

	}

	
	static void findRoute(int[][] arr, int[][] cost) {
		PriorityQueue<Point> q = new PriorityQueue<>();
		
		q.add(new Point(0,0, arr[0][0]));
		cost[0][0] = arr[0][0];
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == N-1 && p.y == N-1) {
				answer = p.value;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int a = p.x+xPos[i];
				int b = p.y+yPos[i];
				int value = p.value;
				
				if(a < 0 || a >= N || b < 0 || b >= N) continue;
				
				if(cost[a][b] > value+arr[a][b]) {
					q.add(new Point(a,b,value+arr[a][b]));
					cost[a][b] = value+arr[a][b];
				}
				
			}

		}
		
	}


}


class Point implements Comparable<Point>{
	
	int x;
	int y;
	int value;
	
	
	Point(int x, int y, int value){
		this.x = x;
		this.y = y;
		this.value = value;
	}

	@Override
	public int compareTo(Point p) {	
		return this.value-p.value;
	}
	
	
}
