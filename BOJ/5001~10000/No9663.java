import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 9663번 N-Queen
백트랙킹의 기본 문제

*/

public class Main {

	static int[] arr;
	static int n;
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		answer = 0;

		check(0);

		System.out.print(answer);

	}

	static void check(int depth) {

		if (depth == n) {
			answer++;
			return;
		}

		
		for (int i = 0; i < n; i++) {
			arr[depth] = i; //이 줄에 반드시 놔야 하니까!

			if (checkCross(depth) && checkDia(depth)) {
				check(depth + 1);
			}

		}

	}

	static boolean checkCross(int depth) {

	//이전 것만 체크를 하면 된다.
		for (int i = 0; i < depth; i++) {
			if (arr[i] == arr[depth])
				return false;

		}

		return true;

	}

	static boolean checkDia(int depth) {

		for (int i = 0; i < depth; i++) {
			if (Math.abs(arr[depth] - arr[i]) == Math.abs(i - depth))
				return false;

		}

		return true;

	}

}
