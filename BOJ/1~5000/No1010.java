import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 1010번 다리놓기
조합론 | DP
DP가 아닌 다른 방식으로 풂

순열 조합 이용

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			sb.append(cal(Integer.parseInt(str[0]),Integer.parseInt(str[1]))).append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	
	static long cal(int a, int b) {
		
		if(a == b)
			return 1;
		else {
			long answer = 1;
			for(int i = 1; i<=a; i++) {
				answer *= b--;
				answer /=i;
			}
				
			return answer;
		}
		
		
	}
	
}
