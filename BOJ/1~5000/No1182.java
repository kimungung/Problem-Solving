import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 1182번 부분수열의 합
백트랙킹

*/

public class Main {

	static int[] arr;
	static boolean[] flag;
	static int goalNum;
	static int N;
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		goalNum = Integer.parseInt(st.nextToken());
		arr = new int[N];
		flag = new boolean[N];

		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		calSum(0, 0, 0);
		
		System.out.print(answer);
		
	}
	
	
	static void calSum(int startNum, int sum, int count) {
			
		if(count == N) {
			
			if(sum == goalNum) {
				answer++;
			}
			return;
		}
		
		
		if(sum == goalNum && count > 0) {
			answer++;
		}
		
		
		for(int i=startNum; i<N; i++) {
			
			if(!flag[i]) {
				flag[i] = true;
				calSum(i+1, sum+arr[i], count+1);
				flag[i] = false;
			}
			
		}
		
	}

}
