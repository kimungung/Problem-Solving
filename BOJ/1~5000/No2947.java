import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 2947번 나무 조각
구현, 시뮬레이션 문제.
조금 더 간단히 풀 수 있는 방법이 있다. 
결국 오름차순으로 정렬하는 문제이기 때문에, check Arr와 비교하는 것은 비효율적.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		int[] check = { 1, 2, 3, 4, 5 };
		StringBuilder sb = new StringBuilder();
		boolean loop = true;

		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (loop) {

			for (int i = 0; i < 4; i++) {

				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];

					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					printLine(sb, arr);
				}

			}

			for (int i = 0; i < 5; i++) {

				if (check[i] != arr[i])
					break;
				if (i == 4)
					loop = false;

			}

		}

		System.out.print(sb);

	}

	static void printLine(StringBuilder sb, int[] arr) {

		for (int i = 0; i < 5; i++) {
			sb.append(arr[i]).append(' ');
		}

		sb.append('\n');

	}

}
