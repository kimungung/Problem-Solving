import java.io.*;
import java.util.Stack;

/*
BOJ 9012번 괄호

스택을 이용한 기본 문제.
스택을 이용하지 않고도 풀 수 있다.

*/

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		
		for(int i=0; i<n; i++) {
			char[] arr = br.readLine().toCharArray();
			Stack<Character> st = new Stack<>();
			
			for(int j=0; j<arr.length; j++) {

				if(arr[j] == '(') st.push(arr[j]);
				else {
					if(st.empty()) {
						st.push(arr[j]);
						break;
					}
					if(st.peek() == '(') st.pop();
				}
				
			}
			
			if(st.empty()) System.out.println("YES");
			else System.out.println("NO");
			
		}

	}
	
}
