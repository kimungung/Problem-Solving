import java.io.*;

/*
BOJ 1018번 체스판 다시 칠하기
Bruteforce
char[][] 말고 int[][]를 이용하는 방법으로도 풀이가 가능하다.

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		char[][] arr = new char[n][m];
		int answer = n*m;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			
			for(int j=0; j<m; j++)
				arr[i][j] = str.charAt(j);
			
		}
		
		for(int i=0; i<n-7; i++) {
			for(int j=0; j<m-7; j++) {
				answer = Math.min(answer,Math.min(checkWB(arr,i,j),checkBW(arr,i,j)));
			}
		}
		
		System.out.println(answer);
	
	}
	
	
	static int checkWB(char[][] arr, int n, int m) {
		int answer = 0;
		
		
		for(int i=n; i<n+8; i++) {
			
			for(int j=m; j<m+8; j++) {
				
				if(i%2 == 0 && j%2 ==0 || i%2 != 0 && j%2 !=0) {
					if(arr[i][j] != 'W') answer++;
				}else {
					if(arr[i][j] != 'B') answer++;
				}

			}
	
		}
		
		return answer;
		
	}
	
	
	static int checkBW(char[][] arr, int n, int m) {
		int answer = 0;
		
		
		for(int i=n; i<n+8; i++) {
			
			for(int j=m; j<m+8; j++) {
				
				if(i%2 == 0 && j%2 ==0 || i%2 != 0 && j%2 !=0) {
					if(arr[i][j] != 'B') answer++;
				}else {
					if(arr[i][j] != 'W') answer++;
				}

			}
	
		}
		
		return answer;
		
	}
	
	
}
