import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 2644번 촌수계산
그래프 이론

*/

public class Main {

	static int n;
	static int personA;
	static int personB;
	static LinkedList<Integer>[] arr;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new LinkedList[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		personA = Integer.parseInt(st.nextToken());
		personB = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(br.readLine());
		answer = 0;

		for (int i = 0; i <= n; i++)
			arr[i] = new LinkedList<Integer>();

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a].add(b);
			arr[b].add(a);
		}

		bfs();

		System.out.print(answer);

	}

	static void bfs() {
		LinkedList<Integer> q = new LinkedList<>();
		int count = 0;
		boolean[] flag = new boolean[n + 1];

		q.add(personA);
		flag[personA] = true;

		while (!q.isEmpty()) {
			int leng = q.size();

			count++;

			for (int i = 0; i < leng; i++) {
				int num = q.poll();
				int size = arr[num].size();

				for (int j = 0; j < size; j++) {
					int person = arr[num].poll();

					if (person == personB) {
						answer = count;
						return;
					} else if (!flag[person]) {
						flag[person] = true;
						q.add(person);
					}

				}

			}

		}

		answer = -1;

	}

}
