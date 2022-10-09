import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
BOJ 10974번 모든 순열
백트래킹

*/

public class Main {

	static int N;
	static boolean[] flag;
	static StringBuilder sb;
	static Stack<Integer> arr = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		flag = new boolean[N+1];
		sb = new StringBuilder();
		
		permutation(0);
		
		System.out.print(sb);
		
	}

	
	
	static void permutation(int leng) {
		
		if(leng == N) {
			for(int i=0; i<N; i++) {
				sb.append(arr.get(i)).append(' ');
			}
			
			sb.append('\n');
			return;
		}
		
		
		for(int i=1; i<=N; i++) {
			
			if(!flag[i]) {
				flag[i] = true;
				arr.add(i);
				permutation(leng+1);
				arr.pop();
				flag[i] = false;
			}

		}
		
		
	}
	

}
