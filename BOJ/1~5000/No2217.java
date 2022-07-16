import java.io.*;
import java.util.Arrays;

/*
BOJ 2217번 로프
Greedy | 정렬
sort를 사용하지 않는 더 단순한 방법이 있다.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int answer = 0;
		
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		answer = arr[0]*n;
		int num = n-1;
		
		for(int i=1; i<n; i++) {
			int sum = arr[i]*num--;
			
			answer = Math.max(answer, sum);	
		}

		System.out.println(answer);

	}

}
