import java.io.*;

/*
BOJ 6588번 골드바흐의 추측
에라토스테네스의 체

*/

public class Main {
	
	static boolean[] check;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new boolean[1000001];
		StringBuilder sb = new StringBuilder();
		
		checkPrime();
		
		while(N != 0) {
			boolean goldbach = false;
			
			for(int i=3; i<= N>>1; i += 2) {
				
				if(check[i] == false && check[N-i] == false) {
					sb.append(N);
					sb.append(" = ");
					sb.append(i);
					sb.append(" + ");
					sb.append(N-i).append('\n');
					goldbach = true;
					break;
				}
				
			}
			
			if(!goldbach)
				sb.append("Goldbach's conjecture is wrong.\n");
			
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.print(sb);
		
	}

	
	static void checkPrime() {
		
		check[0] = check[1] = true;
		
		for(int i=3; i<=1000; i += 2) {
			
			if(!check[i]) {
				
				for(int j=i*i; j<1000001; j +=i)
					check[j] = true;
				
			}
			
		}

	}

}
