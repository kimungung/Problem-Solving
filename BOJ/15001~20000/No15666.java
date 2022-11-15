import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 15666번 N과 M(12)
백트래킹

*/


public class Main {
	
	static StringBuilder answer;
	static int[] arr;
	static int N;
	static int M;
	static int[] string;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[10001];
		string = new int[M];
		answer = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		
		for(int i=0; i<N; i++)
			arr[Integer.parseInt(st.nextToken())]++;
		
		
		print(0,0);
		
		System.out.print(answer);
		
	}
	
	
	static void print(int length, int start) {
		
		if(length == M) {
			
			for(int i=0; i<M; i++) {
				answer.append(string[i]).append(' ');
			}

			answer.append('\n');	
			
			return;
		}
		
		
		for(int i=start; i<10001; i++) {
			
			if(arr[i] != 0) {
				string[length] = i;
				print(length+1, i);
			}			
			
		}
		
	}

}
