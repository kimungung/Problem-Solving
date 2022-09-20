import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 1992번 쿼드트리
재귀 | 분할 정복
*/

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int n;
	static char[][] arr;
	static boolean[][] flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		flag = new boolean[n][n];
		
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		check(0,0,n);

		System.out.print(sb);
		
	}
	
	
	static void check(int x, int y, int leng) {
		boolean check = true;
		char first = arr[x][y];
		
		if(leng == 1) {
			sb.append(arr[x][y]);
			return;
		}
		
		
		for(int i=x; i<x+leng; i++) {
			
			for(int j=y; j<y+leng; j++) {
				if(arr[i][j] != first && check) {
					int nextLeng = leng >> 1;
					check= false;
					sb.append('(');
					check(x, y, nextLeng);
					check(x, y+nextLeng, nextLeng);
					check(x+nextLeng, y, nextLeng);
					check(x+nextLeng, y+nextLeng, nextLeng);
					sb.append(')');
				}	
			}
			
		}
		
		if(check) {
			sb.append(first);
		}
		
	}

	
}
