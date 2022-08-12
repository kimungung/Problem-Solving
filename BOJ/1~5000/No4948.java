import java.io.*;

/*
BOJ 4948번 베르트랑 공준
Prime Number | 에라토스테네스의 체
에라토스테네스의 체 방법 말고 다른 방법을 사용했다. (시간 복잡도는 더 ↑)
*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while( n != 0) {
			int max = 2*n;
			int answer = 0;
			
			for(int i=n+1; i<=max; i++) {
				
				if(checkPrime(i))
					answer++;
			}
			
			sb.append(answer).append('\n');
			
			
			n = Integer.parseInt(br.readLine());
		}
		
		System.out.print(sb);
		
	}
	
	
	static boolean checkPrime(int num) {
		
		double max = Math.sqrt(num);
		
		if(num == 2) return true;
		
		for(int i=2; i <= max; i++) {
			
			if(num%i == 0)
				return false;
		}
		
		return true;
	}

}
