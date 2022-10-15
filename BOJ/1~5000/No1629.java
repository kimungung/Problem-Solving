import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 1629번 곱셈
분할 정복을 이용한 거듭 제곱
*/

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long answer = 0;
		a %= c;
		
		answer = pow(a,b,c);
		
		System.out.print(answer%c);
	
	}
	
	static long pow(long a, long b, long c) {
		
		if(b == 0) {
			return 1;
		}else if(b == 1) {
			return a;
		}else if(b%2 == 0) {
			long n = pow(a, b>>1,c)%c;
			
			return (n*n)%c;
		}else {
			long n = pow(a, b>>1,c)%c;
			
			return ((n*n)%c*a)%c;
		}
		
		
	}

}
