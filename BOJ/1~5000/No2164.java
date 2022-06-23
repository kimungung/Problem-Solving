import java.io.*;
import java.util.LinkedList;

/*

BOJ 2164번 카드2
큐, 수학적 규칙

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=n; i++)
			q.offer(i);
		
		for(int i=0; i<n-1; i++) {
			q.poll();
			q.offer(q.poll());
			
		}
		
		System.out.print(q.peek());

	}

}
