import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

BOJ 1526번 가장 큰 금민수
수학, 구현, 브루트포스 

*/

public class Main {
	
	static int answer = 0;
	static int num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		solve(0);

		System.out.print(answer);
		
	}
	
	
	static void solve(int n) {
		
		if(n > num) return;
		
		answer = Math.max(answer, n);
		
		solve(n*10+4);
		solve(n*10+7);
		
	}
	
	

}
