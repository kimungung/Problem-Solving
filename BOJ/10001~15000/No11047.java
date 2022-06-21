import java.io.*;

/*
BOJ 11047번
Greedy
동전의 종류가 A1의 배수. 조건이 특이해서 DP가 필요없다.

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int[] arr = new int[Integer.parseInt(str[0])];
		int value = Integer.parseInt(str[1]);
		
		for(int i=0; i<arr.length; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		System.out.print(calNum(value, arr));
		
		
	}
	
	static long calNum(int value, int[] arr) {
		int sum = 0;
	
		for(int i=arr.length-1; i>=0; i--) {
			
			if(value/arr[i] != 0) {
				sum += value/arr[i];
				value %= arr[i];
			}
			
		}
		
		return sum;
		
	}

}
