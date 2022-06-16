import java.io.*;

/*
BOJ 1436번 영화감독 숌
Bruteforce 
앞의 자릿수와 뒤의 자릿수를 고려해 더 효율적으로 푸는 방법이 있다.
*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String answer="";
		int count = 0;
		
		
		if(n == 1) {
			System.out.println("666"); return;
		}
		
		for(int i=666; ; i++) {
			if(Integer.toString(i).contains("666")) {
				answer = Integer.toString(i);
				count++;
			}
			
			if(count >= n) break;
		}
		
		System.out.print(answer);
		
	}

}
