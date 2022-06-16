import java.io.*;

/*
BOJ 1094번 막대기
2진수, 수학, 비트마스킹

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(Integer.bitCount(n));

	}

}
