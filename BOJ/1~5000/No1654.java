import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 1654번 랜선 자르기
이진 탐색 + Upper Bound 개념

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		long sum = 0;
		
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		long max = sum/n+1;
		long min = 1;
		long mid;
		long answer = 0;
		
		while(min <= max) {
			mid = (min+max) >> 1;
			int num = 0;
			
			for(int i: arr) {
				num += i/mid;
			}
			
			if(num >= n) {
				answer = Math.max(mid, answer);
				min = mid+1;
			}else{
				max = mid-1;
			}
			
		}
		
		System.out.print(answer);

	}

}
