import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 15663번 N과 M(9)
백트래킹

*/

public class Main {

	static int N;
	static int M;
	static StringBuilder answer;
	static int[] arr;
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[10001];
		num = new int[M];
		answer = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			arr[Integer.parseInt(st.nextToken())]++;
		
		findAnswer(0);
		
		System.out.print(answer);
		
	}
	
	
	static void findAnswer(int length) {
		
		if(length == M) {
			
			for(int i=0; i<M; i++)
				answer.append(num[i]).append(' ');
			
			answer.append('\n'); return;
			
		}else {
			
			for(int i=1; i<=10000; i++) {
				
				if(arr[i] != 0) {
					num[length] = i;
					arr[i]--;
					findAnswer(length+1);
					arr[i]++;
				}
				
			}
			
		}
		
	}
	

}
