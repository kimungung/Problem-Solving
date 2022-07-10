import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 14501번 퇴사
Bruteforce | DP
DP가 아닌 다른 방식으로 풀었다.

*/

public class Main {

	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());	
		}
		
		System.out.print(calMax(1,0));
		
	}
	
	static int calMax(int start, int sum) {
		
		if(start > N) {
			return sum;
		}else if(start+arr[start][0] > N+1){
			return Math.max(sum, calMax(start+1,sum));
		}else{
			return Math.max(calMax(start+arr[start][0],sum+arr[start][1]),calMax(start+1,sum));
		}

	}
	
	
}
