import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 1074번 Z
재귀 분할 정복

*/

public class Main {

	static int n;
	static int a;
	static int b;
	static int count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int length = (int) Math.pow(2, n) >> 1;

		sol(a, b, length);

	}

	static void sol(int a, int b, int length) {
		int x = 0; // 사분면을 나누기 위한 수
		int y = 0;

		if (a == 0 && b == 0) {
			System.out.print(count);
			return;
		}

		if (a < length) {
			x = 0;
		} else {
			x = length;
		}

		if (b < length) {
			y = 0;
		} else {
			y = length;
		}

		if (x == 0 && y != 0) {
			count += length * length;
			b -= length;
		} else if (x != 0 && y == 0) {
			count += length * length * 2;
			a -= length;
		} else if (x != 0 && y != 0) {
			count += length * length * 3;
			a -= length;
			b -= length;
		}

		sol(a, b, length >> 1);

	}



}
