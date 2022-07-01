import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
BOJ 2606번 바이러스
그래프 탐색 | DFS | BFS
DFS를 이용해 풀었다.

*/

public class Main {
	
	static int answerNum;
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		boolean[][] com = new boolean[num+1][num+1];
		flag = new boolean[num+1];
		num = Integer.parseInt(br.readLine());
		answerNum = 0;
		
		Arrays.fill(flag,false);
		
		for(int i=0; i<num; i++) {
			String[] str = br.readLine().split(" ");
			//연결 표시
			com[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = true;
			com[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = true;
		}		

		check(com, 1);
				
		System.out.print(answerNum);
		
	}
	
	
	static void check(boolean[][] com, int start) {
		
		flag[start] =true;
		
		for(int i=1; i<com[start].length; i++) {
			
			if(com[start][i]) {				
				if(!flag[i]) {
					answerNum++;
					check(com, i);					
				}				
			}	
		}		
		
	}
	
	
}
