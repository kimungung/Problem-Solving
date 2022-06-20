import java.io.*;
import java.util.Stack;

/*
BOJ 1874번 스택 수열
스택, label 등
int[] 로 구현할 수도 있다.

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		int num = 1;
		StringBuilder sb = new StringBuilder("");
		
		
		loop: for(int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			
			while(st.empty() || st.peek() != a) {
				
				if(st.empty()) {
					st.push(num++);
					sb.append("+\n");
				}else if(num > n && st.peek() != a) {
					sb.replace(0,sb.length(),"NO"); break loop;
				}else {
					st.push(num++);
					sb.append("+\n");
				}
				
			}
			
			st.pop();
			sb.append("-\n");
			
		}
		
		System.out.print(sb);
		
	}
	


}
