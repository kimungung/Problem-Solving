import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
BOJ 10451번 순열 사이클
순열 사이클 분할

*/

public class Main {

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
			boolean[] flag = new boolean[n + 1];
			answer = 0;

			arr.add(new ArrayList<>());

			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(st.nextToken());
				ArrayList<Integer> temp = new ArrayList<>();

				temp.add(num);
				arr.add(temp);
			}

			for (int i = 1; i <= n; i++) {

				if (!flag[i]) {
					findCycle(n, i, arr, flag);
				}

			}

			sb.append(answer).append('\n');

		}

		System.out.print(sb);

	}

	static void findCycle(int n, int i, ArrayList<ArrayList<Integer>> arr, boolean[] flag) {
		Queue<Integer> q = new LinkedList<>();

		flag[i] = true;
		q.add(arr.get(i).get(0));

		while (!q.isEmpty()) {
			int next = q.poll();

			if (flag[next]) {
				answer++;
				return;
			}

			flag[next] = true;
			q.add(arr.get(next).get(0));

		}

	}

}
