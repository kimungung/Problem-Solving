import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 14502번 연구소
그래프탐색 | Bruteforce

*/

public class Main {

	static int N;
	static int M;
	static LinkedList<Room> q;
	static int sum;
	static int answer;
	static int[] xPos = { -1, 1, 0, 0 };
	static int[] yPos = { 0, 0, -1, 1 };

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		answer = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());

				if (num == 2) {
					q.add(new Room(i, j));
				} else if (num == 0) {
					sum++;
				}

				arr[i][j] = num;

			}
		}

		
		setWall(0, 0, 0, arr);

		System.out.print(answer);

	}

	static void setWall(int n, int m, int count, int[][] arr) {

		if (count == 3) {
			answer = Math.max(answer, bfs(arr));
		} else {

			for (int i = n; i < N; i++) {
				for (int j = m; j < M; j++) {

					if (arr[i][j] == 0) {
						arr[i][j] = 1;
						setWall(i, j, count + 1, arr);
						arr[i][j] = 0;
					}

				}
				m=0;
			}

		}

	}

	static int bfs(int[][] arr) {
		LinkedList<Room> que = new LinkedList<>();
		int ans = sum - 3;
		boolean[][] flag = new boolean[N][M];

		for (int i = 0; i < q.size(); i++) {
			que.add(q.get(i));
		}

		while (!que.isEmpty()) {
			Room r = que.poll();

			for (int i = 0; i < 4; i++) {
				int x = r.x + xPos[i];
				int y = r.y + yPos[i];

				if (x >= 0 && x < N && y >= 0 && y < M) {

					if (arr[x][y] == 0 && !flag[x][y]) {
						flag[x][y] = true;
						ans--;
						que.add(new Room(x, y));
					}

				}

			}

		}

		return ans;

	}

}

class Room {

	int x;
	int y;
	int virus;

	Room(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
