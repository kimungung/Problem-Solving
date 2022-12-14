import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 7569번 토마토
BFS | 그래프이론

*/

public class Main {

	static int m;
	static int n;
	static int h;
	static int[][][] box;
	static LinkedList<Box> q = new LinkedList<>();
	static int count; // 덜 익은 tomato
	static int answer;
	static int[] xPos = { -1, 1, 0, 0, 0, 0 };
	static int[] yPos = { 0, 0, -1, 1, 0, 0 };
	static int[] zPos = { 0, 0, 0, 0, 1, -1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		box = new int[h][n][m];
		count = 0;
		answer = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					int num = Integer.parseInt(st.nextToken());

					if (num == 1) {
						q.offer(new Box(i, j, k));
					} else if (num == 0) {
						count++;
					}

					box[i][j][k] = num;
				}
			}
		}

		bfs();

		if (count != 0) {
			System.out.print(-1);
		} else {
			System.out.print(answer);
		}

	}

	static void bfs() {

		while (!q.isEmpty()) {
			int length = q.size();

			if (count == 0)
				return;

			answer++;

			for (int j = 0; j < length; j++) {
				Box tomato = q.poll();

				for (int i = 0; i < 6; i++) {
					int a = tomato.x + xPos[i];
					int b = tomato.y + yPos[i];
					int c = tomato.z + zPos[i];

					if (a < 0 || b < 0 || c < 0 || a >= h || b >= n || c >= m)
						continue;

					if (box[a][b][c] == 0) {
						box[a][b][c] = 1;
						count--;
						q.offer(new Box(a, b, c));
					}

				}
			}

		}

	}

}

class Box {

	int x;
	int y;
	int z;

	Box(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

}
