import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
BOJ 9375번 패션왕 신해빈
수학 | 조합론 | 해시를 이용한 집합과 맵
Map을 이용하는 것이 더 간단하고 효율적이다.
*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>();
			ArrayList<String> strArr = new ArrayList<>();
			int answer = 1;

			if (num == 0) {
				sb.append(0).append('\n');
				continue;
			}

			for (int i = 0; i < num; i++) {
				String[] str = br.readLine().split(" ");

				if (strArr.contains(str[1])) {
					int arrN = strArr.indexOf(str[1]);

					arr.set(arrN, arr.get(arrN) + 1);
				} else {
					strArr.add(str[1]);
					arr.add(1);
				}

			}

			for (int i = 0; i < arr.size(); i++) {
				answer = answer * (arr.get(i) + 1);
			}

			sb.append(answer - 1).append('\n');

		}

		System.out.print(sb);

	}

}
