import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 14888번 연산자 끼워넣기
백트랙킹 | Bruteforce

*/

public class Main {

	static int N;
	static int[] input;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			input[i] = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++)
			op[i] = Integer.parseInt(st.nextToken());
		
		
		backtrack(input[0],1);
		
		System.out.println(max);
		System.out.print(min);

	}
	
	static void backtrack(int value, int len) {
		
		if(len == N) {
			max = Math.max(value, max);
			min = Math.min(value, min);
			return;
		}
		
		
		for(int i=0; i<4; i++) {
			if(op[i] != 0) {
				op[i]--;
				
				switch(i) {
				
				case 0:
					backtrack(value+input[len],len+1);
					break;
				case 1:
					backtrack(value-input[len],len+1);
					break;
				case 2:
					backtrack(value*input[len],len+1);
					break;
				case 3:
					backtrack(value/input[len],len+1);
					break;

				}
				
				op[i]++;
			}
			
		}

		
	}

}
