import java.io.*;

/*
BOJ 1929번 소수 구하기
소수, 에라토스테네스의 체
에라토스테네스의 체를 이용해 구하는 것이 더 빠르다.

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int[] arr = new int[2];
		arr[0] = Integer.parseInt(str[0]);
		arr[1] = Integer.parseInt(str[1]);
		StringBuilder sb = new StringBuilder("");
		
		for(int i=arr[0]; i<= arr[1]; i++) {
			if(isPrimeNum(i)) sb.append(i+"\n");
		}
		
		System.out.print(sb);
		
	}
	
	static boolean isPrimeNum(int n) {
		
		
		if(n == 1) return false;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			
			if(n%i == 0) return false;
			
		}
		
		return true;
	}

}
