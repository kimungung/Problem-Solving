import java.io.*;

/*
BOJ 2447번 별찍기 -10
분할 정복 | 재귀

*/

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		StringBuilder sb = new StringBuilder();

		printDot(0, 0, n);

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (arr[i][j] == '*')
					sb.append(arr[i][j]);
				else
					sb.append(' ');
			}

			sb.append('\n');
		}

		System.out.print(sb);

	}

	static void printDot(int startX, int startY, int leng) {
		int nextLeng = leng / 3;

		if (leng == 1) {
			arr[startX][startY] = '*';
			return;
		}

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1))
					printDot(startX + i * nextLeng, startY + j * nextLeng, nextLeng);
			}

		}

	}

}
