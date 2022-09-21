import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 2693번 N번째 큰 수
정렬의 기초

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (n-- > 0) {
			int[] arr = new int[10];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 10; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(arr);

			sb.append(arr[7]).append('\n');
		}

		System.out.print(sb);

	}

}
