import java.io.*;

/*
BOJ 1904번 01타일
DP
arr 없이 풀 수도 있다.
*/

public class Main {

	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+2];
		
		arr[1] = 1;
		arr[2] = 2;
		
		for(int i=3; i<=n; i++) {
			arr[i] = (arr[i-1]+arr[i-2])%15746;
		}
		
		System.out.print(arr[n]);
		
	}

}
