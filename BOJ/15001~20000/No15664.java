import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 15664번 N과 M (10)
백트래킹

*/

public class Main {

	static StringBuilder sb;
	static int n;
	static int m;
	static int[] arr;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		arr = new int[10001];
		answer = new int[m];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++)
			arr[Integer.parseInt(st.nextToken())]++;

		findAnswer(0, 1);

		System.out.print(sb);

	}

	static void findAnswer(int leng, int min) {

		if (leng == m) {

			for (int i = 0; i < m; i++)
				sb.append(answer[i]).append(' ');

			sb.append('\n');
			return;

		}

		for (int i = min; i < 10001; i++) {

			if (arr[i] > 0) {
				answer[leng] = i;
				arr[i]--;
				findAnswer(leng + 1, i);
				arr[i]++;
			}

		}

	}

}
