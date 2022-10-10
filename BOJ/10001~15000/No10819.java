import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 10819번 차이를 최대로
백트래킹

*/

public class Main {

	static int N;
	static boolean[] flag;
	static int[] arr;
	static int[] input;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		flag = new boolean[N];
		arr = new int[N];
		input = new int[N];
		answer = 0;
		
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		cal(0);
		
		System.out.print(answer);
		
	}

	
	
	static void cal(int depth) {
		
		if(depth == N) {
			int value = 0;
			
			for(int i=1; i<N; i++) {
				int a = input[i-1];
				int b = input[i];
				
				if(a > b)
					value += a-b;
				else
					value += b-a;
			}
			answer = Math.max(value, answer);
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			
			if(!flag[i]) {
				flag[i] = true;
				input[depth] = arr[i];
				cal(depth+1);
				flag[i] = false;
			}

		}
		
		
	}
	

}
