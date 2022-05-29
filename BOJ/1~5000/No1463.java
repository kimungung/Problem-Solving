import java.io.*;

/*

BOJ 1463번 1로 만들기
DP를 이용한다.
Math.min을 이용하면, 보다 코드가 간결해진다.

*/

public class Main {
	
	static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[1000001];
		
		System.out.println(calMin(n));
		
	}
	
	
	static int calMin(int n) {
		
		if(n == 1) return 0;
		else if(n == 2 || n == 3) return 1;
		else if(n == 6) return 2;
		else if(arr[n] != 0) return arr[n];
		else {
				
			if(n%3 != 0 && n%2 != 0) return arr[n] = calMin(n-1)+1;
			else if(n%6 == 0) {
				if(calMin(n/3) > calMin(n >> 1)) return calMin(n >> 1) > calMin(n-1) ? (arr[n] = calMin(n-1)+1) : (arr[n] = calMin(n >> 1)+1);
				else return calMin(n/3) > calMin(n-1) ? (arr[n] = calMin(n-1)+1) : (arr[n] = calMin(n/3)+1);
			}else if(n%3 == 0) return calMin(n/3) > calMin(n-1) ? (arr[n] = calMin(n-1)+1) : (arr[n] = calMin(n/3)+1);
			else return calMin(n >> 1) > calMin(n-1) ? (arr[n] = calMin(n-1)+1) : (arr[n] = calMin(n >> 1)+1);
		}
		
	}
	
}
