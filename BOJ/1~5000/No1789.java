import java.io.*;

/*

BOJ 1789번 수들의 합


*/

public class Main {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long answer = 1;
		long s = 1;
		
		for(long i=2; s<n; i++){			
			s += i;			
			if(s > n)
				break;
			answer++;
		}
		
		System.out.println(answer);
		
	}
	
}
