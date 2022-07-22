import java.io.*;
import java.util.Stack;

/*
BOJ 10799번 쇠막대기
스택 -> 스택 없이 풀 수 있다.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		char preChar = '\0';
		int answer = 0;
		
		for(int i=0; i<str.length(); i++) {			

			if(str.charAt(i) == ')') {
				st.pop();
					
				if(preChar == '(') {
					answer--;
					answer += st.size();
				}
				
				preChar = ')';
			}else {
				st.push(str.charAt(i));
				answer++;
				preChar = '(';
			}
				
		}
		
		System.out.print(answer);

	}

}
