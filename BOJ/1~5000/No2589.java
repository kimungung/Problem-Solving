import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 2589번 계단 오르기
DP

*/

public class Main {
	
	static int[] sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		sum = new int[n];
		
		System.out.println("sum[0] =" + sum[0] );
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		
		System.out.print(cal(arr,n-1));
		
	}

	
	static int cal(int[] arr, int n) {
		
		if(n == 0) {
			return arr[0];
		}else if(n == 1) {
			return arr[1]+arr[0];
		}else if(n == 2) {
			return arr[2]+(arr[0] > arr[1] ? arr[0]:arr[1]);
		}else if(sum[n] != 0) {
			return sum[n];
		}else {
			int a = cal(arr, n-3) + arr[n-1];
			int b = cal(arr, n-2);
			
			return sum[n] = arr[n] +(a>b ? a:b);
			
		}	
		
	}
	
}
