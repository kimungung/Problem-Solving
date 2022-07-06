import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 10823번 더하기 2
문자열 | 파싱
StringTokenizer로 자르면 메모리면에서 조금 더 효율적
*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringBuilder sb = new StringBuilder();
		int sum = 0;

		while ((str = br.readLine()) != null && !str.isBlank()) {
			sb.append(str);
		}

		String[] arr = sb.toString().split(",");

		for (int i = 0; i < arr.length; i++)
			sum += Integer.parseInt(arr[i]);

		System.out.println(sum);
	}

}
