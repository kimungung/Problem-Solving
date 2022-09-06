import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 4963번 풀이 섬의 개수
dfs | bfs | 그래프 탐색
연결개수 구하는 문제

*/

public class Main {
	
	static int w;
	static int h;
	static int[] xPos = {-1, -1, -1, 0 ,0, 1, 1, 1};
	static int[] yPos = {-1, 0, 1, -1, 1, -1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			int[][] arr = new int[h][w];
			int count = 0;
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					
					if(arr[i][j] != 0) {
						count++;
						dfs(arr, i, j);
					}
				}
			}
			
			sb.append(count).append('\n');
			
		}
		
		
		System.out.print(sb);
		
	}
	
	
	
	static void dfs(int[][] arr, int x, int y) {
		
		for(int i=0; i<8; i++) {
			int a = x+xPos[i];
			int b = y+yPos[i];
			
			if(a>=0 && a<h && b<w && b>=0) {
				if(arr[a][b] != 0) {
					arr[a][b] = 0;
					dfs(arr, a, b);
				}
			}
			
		}

	}


}
