import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 2999번 비밀 이메일
구현 | 문자열
더 단순하게 규칙을 이용해 풀 수 있다.
*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int leng = str.length();
		int R = 1;
		int C = 1;
		StringBuilder sb = new StringBuilder();

		for (int i = (int) Math.sqrt(leng); i >= 1; i--) {

			if (leng % i == 0) {
				R = i;
				C = leng / i;
				break;
			}

		}


		char[][] arr = new char[R][C];
		int count = 0;

		while (count < leng) {
			arr[count % R][count / R] = str.charAt(count);
			count++;
		}

		count = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				sb.append(arr[i][j]);
				count++;

				if (count == leng) {
					System.out.println(sb);
					return;
				}

			}

		}

	}

}
