import java.io.*;

/*
BOJ 1292번 쉽게 푸는 문제
수학, DP
*/

public class Main {
	
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int a = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		arr = new int[1001];
		
		sum(b);
		System.out.print(arr[b]-arr[a-1]);
		
	}
	
	static int sum(int n) {
		
		if(n == 0) return 0;
		else if(arr[n] != 0) return arr[n];
		else {
			
			return arr[n] = sum(n-1)+(int)Math.ceil((Math.sqrt(8*n+1)-1)/2);
		}
	}

}
