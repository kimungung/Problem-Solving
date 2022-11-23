import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
BOJ 17219번 비밀번호 찾기
해시를 이용한 집합과 맵 | 자료구조 | HashMap

*/


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<String, String>(N);
		StringBuilder sb = new StringBuilder();

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine())).append('\n');
		}

		System.out.print(sb);

	}

}
