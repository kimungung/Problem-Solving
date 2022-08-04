import java.io.*;
import java.util.Stack;

/*
BOJ 1406번 에디터
stack 2개를 사용해 경계점을 cursor로 지정하는 방법
LinkedList Iterator를 사용하는 방법도 있다.
*/


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int n = Integer.parseInt(br.readLine());
		Stack<Character> front = new Stack<>();
		Stack<Character> back = new Stack<>();

		
		for(int i=0; i<input.length(); i++) {
			front.add(input.charAt(i));
		}

		
		for (int i = 0; i < n; i++) {
			char[] arr = br.readLine().toCharArray();

			switch (arr[0]) {

			case 'L':
				if (!front.isEmpty())
					back.push(front.pop());
				break;
			case 'D':
				if (!back.isEmpty())
					front.push(back.pop());
				break;
			case 'B':
				if (!front.isEmpty()) {
					front.pop();
				}
				break;
			case 'P':
				front.push(arr[2]);
				break;
			default:
				System.out.println("Check Input!");

			}

		}
		

		for (int i = 0; i < front.size(); i++)
			bw.write(front.get(i));
		
		for (int i = back.size()-1; i >=0; i--)
			bw.write(back.get(i));

		
		bw.flush();
		bw.close();

	}

}
