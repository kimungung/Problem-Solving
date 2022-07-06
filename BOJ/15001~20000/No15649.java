import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 15649번 N과 M(1)
백트래킹의 기본
*/

public class Main {

	static int N,M;
	static int[] arr;
	static boolean[] visited;
	static BufferedWriter bw;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N];
		
		
		backtracking(0);
		
		
		bw.flush();
		bw.close();
		
	}
	
	static void backtracking(int k) throws Exception{
		
		if(k == M) {
			
			for(int i=0; i<M; i++) {
				bw.write(arr[i]+" ");	
			}
			
			bw.write('\n');
			return ;
		}
		
		
		for(int i=1; i<=N; i++) {
			
			if(!visited[i-1]) {
				arr[k] = i;
				visited[i-1] = true;
				backtracking(k+1);
				visited[i-1] = false;
			}	
		}

	}

	
}
