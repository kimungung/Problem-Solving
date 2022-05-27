import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/*

1261번 알고스팟
이 문제의 핵심은 '벽을 최소한으로 부수는 경우'를 찾는 것이라는 것.

우선순위큐를 이용하거나, 
deque을 이용하는 방법이 더 빠르고 단순하다.

*/

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int[] xPos = { -1, 1, 0, 0 };
	static int[] yPos = { 0, 0, -1, 1 };
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		M = Integer.parseInt(strArr[0]);
		N = Integer.parseInt(strArr[1]);
		arr = new int[N][M];
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();

		if(N == 1 && M == 1)
			System.out.print(0);
		else
			System.out.print(answer);

	}

	static void bfs() {
		LinkedList<Point> q = new LinkedList<>();
		int[][][] flag = new int[N][M][2];

		q.add(new Point(0, 0, 0));

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.count >= answer)
				continue;

			if (p.x == N - 1 && p.y == M - 1) {
				answer = p.count;
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int x = p.x + xPos[i];
				int y = p.y + yPos[i];

				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;

				
				if (flag[x][y][0] == 0) {

					if (arr[x][y] == 1) {
						q.add(new Point(x, y, p.count + 1));
					} else {
						q.add(new Point(x, y, p.count));
					}

					flag[x][y][0] = 1;
					flag[x][y][1] = p.count;

				} else if (flag[x][y][1] > p.count) {

					if (arr[x][y] == 1) {
						q.add(new Point(x, y, p.count + 1));
					} else {
						q.add(new Point(x, y, p.count));
					}

					flag[x][y][1] = p.count;

				}

			}

		}

	}

}

class Point {

	int x;
	int y;
	int count;

	Point(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}

}
