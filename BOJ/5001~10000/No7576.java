import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BOJ 7576번 토마토

*/

public class Main {

	static int w, h;
	static int[][] arr;
	static boolean[][] flag;
	static int[] arrX = { -1, 0, 0, 1 };
	static int[] arrY = { 0, -1, 1, 0 };
	static Queue<Point> q;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h][w];
		flag = new boolean[h][w];
		answer = 0;
		q = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < w; j++) {
				int a = Integer.parseInt(st.nextToken());
				
				if(a == 1) {
					q.add(new Point(i,j,0));
					arr[i][j] = -1;
				}else {
					arr[i][j] = a;
				}
			}

		}
		
		
		while (!q.isEmpty()) {
			Point p1 = q.poll();
			int a = p1.x;
			int b = p1.y;
			int date = p1.date;
			
			for (int j = 0; j < 4; j++) {
				int nextX = a + arrX[j];
				int nextY = b + arrY[j];

				if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w) {
					if ( arr[nextX][nextY] == 0) {
						arr[nextX][nextY] = date+1;
						q.offer(new Point(nextX, nextY, date + 1));
					}

				}
			}

		}

		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == 0) {
					System.out.print(-1);
					return;
				}else if(arr[i][j] > 0) {
					answer = Math.max(answer, arr[i][j]);
				}
			}
		}

		
		System.out.print(answer);

	}



}

class Point {

	public int x;
	public int y;
	public int date;

	public Point(int x, int y, int date) {
		this.x = x;
		this.y = y;
		this.date = date;
	}

	public int getDate() {
		return date;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
