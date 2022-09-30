import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 2003번 수들의 합
두 포인터

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int[] arr = new int[size+1];
		int answer = 0;
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=size; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=size; i>=1; i--) {
			
			for(int j=i-1; j>=0; j--) {
				int n = arr[i] - arr[j];
				
				if(n > num) break;
				
				if(n == num) answer++;
				
			}
			
		}
		
		
		System.out.print(answer);
		
	}


}
