import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 2805번 나무 자르기
이진 탐색

*/

public class Main {
	
	static int n;
	static int m;
	static long[] arr;
	static long answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		long max = 0;

		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if( max < arr[i]) max = arr[i];
		}
			
		binarySearch(0, max);
		
		System.out.print(answer);
		
	}
	
	
	static void binarySearch(long min, long max) {
		
		if(min > max) {
			
			return;
		}
		
		long mid = (min+max) >> 1;
		long sum = calTree(mid);
			
		if(sum == m) {
			answer = mid;
			return;
		}else if(sum < m) {
			binarySearch(min, mid-1);
		}else {
			if(answer < mid)
				answer = mid;
			binarySearch(mid+1, max);
		}
		
	}
	
	
	static long calTree(long h) {
		long sum = 0;
		
		for(int i=0; i<n; i++) {			
			if(h < arr[i])
				sum += (arr[i]-h);		
		}
		
		return sum;
	}
	
}
