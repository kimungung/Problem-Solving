import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/*
BOJ 17298번 오큰수
Stack의 심화 문제

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer token = new StringTokenizer(br.readLine());
		StringBuilder answer = new StringBuilder();
		int[] numbers = new int[n];
		int[] answerArr = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<n; i++)
			numbers[i] = Integer.parseInt(token.nextToken());


		Arrays.fill(answerArr, -1);
		//stack에 쌓이는 것은 오큰수를 찾지 못한 수!
		st.push(0);

		for(int i=0; i<n; i++) {
			
			while(!st.empty() && numbers[st.peek()] < numbers[i]) {
				answerArr[st.peek()] = numbers[i];
				//A[st.peek()]의 오큰수를 찾았으므로, pop해준다.
				st.pop();
			}
			
			if(st.empty() || numbers[st.peek()] >= numbers[i])
				st.push(i);

		}
		
		
		for(int i=0; i<n; i++)
			answer.append(answerArr[i]).append(' ');
			
		bw.write(answer.toString());
		bw.close();
			
	}

}
