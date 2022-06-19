import java.io.*;
import java.util.Arrays;

/*
BOJ 1037번 약수

수학, 정수론 , 유클리드 호제법

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] arr = new int[n];
		long answer = 1;
		
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			
			answer = answer*arr[i]/gcd(Math.max(answer, arr[i]),Math.min(answer, arr[i]));
			
		}
		
		if(arr[n-1] == answer) answer *= arr[0];
		
		System.out.print(answer);
		
	}
	
	
	static long gcd(long a, long b) {
		
		while(true) {
			long r = a%b;
			
			if(r == 0) return b;
			
			a = b;
			b = r;
		}
		
		
		
	}

}
