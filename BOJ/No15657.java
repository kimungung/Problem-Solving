import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 15657번 N과 M(8)
백트랙킹 | 정렬을 했다면, 정렬의 이점을 이용하자.

*/

public class Main {

	static int N;
	static int L;
	static int[] arr;
	static int[] output;
	static StringBuilder answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N];
		output = new int[L];
		answer = new StringBuilder();
		st = new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		
		cal(0);
		
		System.out.print(answer);
		
	}

	
	
	static void cal(int depth) {
		
		if(depth == L) {
			
			for(int i=0; i<L; i++) {			
				answer.append(output[i]).append(' ');
			}
			
			answer.append('\n');
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			
			if(depth >0 &&output[depth-1] <= arr[i] ) {
				output[depth] = arr[i];
				cal(depth+1);
			}else if(depth == 0) {
				output[depth] = arr[i];
				cal(depth+1);
			}
			
		}
		
		
	}
	

}
