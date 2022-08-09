import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 1912번 연속합
DP
*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] sum = new int[n];
		int answer;
		
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		
		sum[0] = arr[0];
		answer = sum[0];
		
		for(int i=1; i<n; i++) {
			
			sum[i] = Math.max(sum[i-1]+arr[i], arr[i]);
			answer = Math.max(answer,sum[i]);
		}

		
		System.out.print(answer);
		

	}


}
