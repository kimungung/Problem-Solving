// 실행 시간을 확! 줄인 방식

import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 1932번 정수 삼각형
DP 
두 가지 방식으로 풀었다. 해당 풀이는 NxN Arr를 사용한 풀이.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int answer = 0;

		arr[0][0] = Integer.parseInt(br.readLine());

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j <= i; j++) {
				int a = Integer.parseInt(st.nextToken());

				if (j == 0) {
					a += arr[i - 1][j];
				} else if (j == i) {
					a += arr[i - 1][j - 1];
				} else {
					a += Math.max(arr[i - 1][j], arr[i - 1][j - 1]);
				}

				arr[i][j] = a;
			}

		}

		for (int i = 0; i < n; i++) {

			if (answer < arr[n - 1][i])
				answer = arr[n - 1][i];
		}

		System.out.print(answer);

	}

}
