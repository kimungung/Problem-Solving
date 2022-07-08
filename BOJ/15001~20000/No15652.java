import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 15652번 N과 M 시리즈
백트래킹의 기본의 변형

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
		visited = new boolean[N+1];		
		
		backtracking(0,1);
		
		
		bw.flush();
		bw.close();
		
	}
	
	static void backtracking(int k, int min) throws Exception{
		
		if(k == M) {
			
			for(int i=0; i<M; i++) {
				bw.write(arr[i]+" ");	
			}
			
			bw.write('\n');
			return ;
		}
		
		
		for(int i=min; i<=N; i++) {
			
			if(!visited[i]) {
				arr[k] = i;
				visited[i] = true;
				backtracking(k+1, i+1);
				visited[i] = false;
			}

			
		}

	}

	
}
