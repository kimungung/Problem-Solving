import java.io.*;

/*
BOJ 4949번 균형잡힌 세상
스택

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while (!(str = br.readLine()).equals(".")) {
			boolean check = true;
			char[] arr = new char[str.length()];
			int point = 0;

			
			for (int i = 0; i < str.length(); i++) {

				if (str.charAt(i) == '(' || str.charAt(i) == '[') {
					arr[point++] = str.charAt(i);
				} else if (str.charAt(i) == ')') {

					if (point != 0 && arr[point - 1] == '(') {
						arr[point - 1] = '\0';
						point--;
					} else {
						check = false;
						break;
					}

				} else if (str.charAt(i) == ']') {

					if (point != 0 && arr[point - 1] == '[') {
						arr[point - 1] = '\0';
						point--;
					} else {
						check = false;
						break;
					}
				}

			}

			if (check && arr[0] == '\0') {
				System.out.println("yes");
			} else
				System.out.println("no");

		}

	}

}
