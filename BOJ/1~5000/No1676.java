import java.io.*;

/*
BOJ 1676번 팩토리얼 0의 개수
큰 수 연산 | 수학

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long numTwo = 0;
		long numFive = 0;
		int answer = 0;
		
		for(int i=2; i<=n; i++) {
			int a = i;
			
			while(a%10 == 0) {
				a /= 10;
				answer++;
			}
			
			while(a%5 == 0) {
				a /= 5;
				numFive++;
			}
			
			while(a%2 == 0) {
				a /= 2;
				numTwo++;
			}
			
		}

		System.out.print(answer+Math.min(numTwo, numFive));

	}

}
