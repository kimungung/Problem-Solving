import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
BOJ 17413번 단어 뒤집기2
문자열 | 스택 | 구현

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder answer = new StringBuilder();
		Stack<Character> st = new Stack<>();
		boolean reverse = true;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (reverse) {

				if (c == '<') {

					reverseS(answer, st);
					reverse = false;
					answer.append(c);

				} else if (c == ' ') {
					
					reverseS(answer, st);
					answer.append(c);
					
				} else {
					st.push(c);
				}

			} else {

				if (c == '>') {
					reverse = true;
				}

				answer.append(c);

			}

		}

		reverseS(answer, st);

		System.out.print(answer);

	}

	static void reverseS(StringBuilder ans, Stack<Character> st) {

		while (!st.isEmpty()) {
			ans.append(st.pop());
		}

	}

}
