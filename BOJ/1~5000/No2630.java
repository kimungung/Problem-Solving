import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 2630번 색종이 만들기
분할정복 | 재귀 | 1992번과 유사하다.

*/

public class Main {

	static int white;
	static int blue;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		white = 0;
		blue = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check(0,0, n);
		
		
		System.out.println(white);
		System.out.println(blue);

	}

	static void check(int x, int y, int leng) {
		int first = arr[x][y];
		boolean same = true;

		if (leng == 1) {
			count(first);
			return;
		}

		for (int i = x; i < x + leng; i++) {

			for (int j = y; j < y + leng; j++) {

				if (arr[i][j] != first) {					
					int newLeng = leng >> 1;
			
					check(x, y, newLeng);
					check(x, y+newLeng, newLeng);
					check(x+newLeng, y, newLeng);					
					check(x+newLeng, y+newLeng, newLeng);
					return;
					
				}

			}

		}

		
		if (same) {
			count(first);
		}

	}

	static void count(int color) {

		if (color == 0)
			white++;
		else
			blue++;

	}

}
