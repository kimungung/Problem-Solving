import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

/*
BOJ 2667번 단지 번호 붙이기
DFS
*/

public class Main {

	static int[][] arr;
	static int N;
	static boolean[][] visited;
	static int num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int sum = 0;
		num = 0;
		visited = new boolean[N][N];
		LinkedList<Integer> answerArr = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
			
		}
		
		for(int i=0; i<N; i++) {
			
			for(int j=0; j<N; j++) {
				num = 0;
				dfs(i, j);
				
				if(num != 0) {
					sum++;
					answerArr.add(num);
				}
	
			}
			
		}
		
		Collections.sort(answerArr);
		
		for(int i=0; i<sum; i++)
			sb.append(answerArr.poll()).append('\n');
		
		System.out.println(sum);
		System.out.print(sb);
		
	}
	
	
	static void dfs(int x, int y) {
		
		if(arr[x][y] == 0 || visited[x][y]) return;
		
		visited[x][y] = true;
		num++;
		
		if(x != 0) {
			if(arr[x-1][y] != 0 && !visited[x-1][y]) {			
				dfs(x-1, y);
			}
		}
		
		if(x < N-1) {
			if(arr[x+1][y] != 0 && !visited[x+1][y]) {
				dfs(x+1, y);
			}
		}
		
		if(y != 0) {
			if(arr[x][y-1] != 0 && !visited[x][y-1]) {
				dfs(x, y-1);
			}
		}
		
		if(y < N-1) {
			if(arr[x][y+1] != 0 && !visited[x][y+1]) {
				dfs(x, y+1);
			}
		}
		
	}


}
