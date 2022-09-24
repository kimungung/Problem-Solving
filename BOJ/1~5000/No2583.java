import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BOJ 2583번 영역 구하기
BFS | 그래프 탐색, 그리프 이론

*/

public class Main {

	static int M;
	static int N;
	static int K;
	static int[][] arr;
	static LinkedList<Integer> answers;
	static boolean[][] flag;
	static int[] xPos = { -1, 1, 0, 0 };
	static int[] yPos = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		answers = new LinkedList<>();
		int num = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int k = y; k < b; k++) {
				for (int j = x; j < a; j++) {
					arr[k][j] = 1;
				}
			}

		}


		for (int i = 0; i < M; i++) {

			for (int j = 0; j < N; j++) {

				if (arr[i][j] == 0 ) {
					num++;
					arr[i][j] = 1;
					bfs(i, j);
				}

			}

		}

		

		sb.append(num).append('\n');

		Collections.sort(answers);

		for (int i = 0; i < answers.size(); i++)
			sb.append(answers.get(i)).append(' ');

		System.out.print(sb);

	}

	
	static void bfs(int a, int b) {
		int answer = 1;
		Queue<Point> q = new LinkedList<>();

		q.add(new Point(a, b));

		while (!q.isEmpty()) {
			Point p1 = q.poll();
			

			for (int i = 0; i < 4; i++) {
				int x = p1.x + xPos[i];
				int y = p1.y + yPos[i];

				if (x >= 0 && x < M && y >= 0 && y < N) {
					if (arr[x][y] == 0) {
						q.add(new Point(x, y));
						answer++;
						arr[x][y] = 1;
					}

				}

			}

		}

		answers.add(answer);

	}

}

class Point {

	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
