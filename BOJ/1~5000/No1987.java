import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 1987번 알파벳
DFS | 백트래킹

*/

public class Main {

	static int R;
	static int C;
	static char[][] arr;
	static int[] xPos = {-1, 1, 0, 0};
	static int[] yPos = {0, 0, 1, -1};
	static boolean[] flag = new boolean[26];
	static int answer;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		answer = 0;
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
					
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		flag[arr[0][0]-'A'] = true;
		dfs(0,0,1);
		
		System.out.print(answer);

	}


	static void dfs(int x, int y, int leng) {
		
		for(int i=0; i<4; i++) {
			int a = x+xPos[i];
			int b = y+yPos[i];		
			
			if(a >=0 && a<R && b>=0 && b<C) {
				int num = arr[a][b]-'A';
				
				if(!flag[num]) {
					
					flag[num] = true;
					dfs(a,b,leng+1);
					flag[num] = false;
					
				}
				
			}
			
		}
		
		if(answer < leng)
			answer = leng;
		
	}
	

}
