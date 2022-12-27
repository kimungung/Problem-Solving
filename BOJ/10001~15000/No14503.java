import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 14503번 로봇 청소기
시뮬레이션 | 탐색

*/

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static LinkedList<int[]> q;
	static int[] xPos = { -1, 0, 1, 0 };
	static int[] yPos = { 0, 1, 0, -1 };
	static int direction;
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		q = new LinkedList<>();
		answer = 0;

		st = new StringTokenizer(br.readLine());

		q.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		direction = Integer.parseInt(st.nextToken());


		for (int i = 0; i <N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j <M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		cleaning();
		
		System.out.print(answer);

	}

	
	static void cleaning() {

		while (!q.isEmpty()) {
			int[] pos = q.poll();
			int x = pos[0];
			int y = pos[1];
			boolean endCheck = true;
			
			if (arr[x][y] == 0) {
				arr[x][y] = 2;
				answer++;
			}
			
			
			for (int i = 0; i < 4; i++) {
				direction = (direction + 3)%4;
				int a = x + xPos[direction];
				int b = y + yPos[direction];

				if (arr[a][b] == 0) {		
					q.add(new int[] { a, b });
					endCheck = false;
					break;
				}

			}

			// 후진한다.
			if (endCheck) {
				int backDirect = (direction + 2) % 4;
				int a = x + xPos[backDirect];
				int b = y + yPos[backDirect];

				if (arr[a][b] == 1) return;

				q.add(new int[] { a, b });

			}

		}

	}

}
