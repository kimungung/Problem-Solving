import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
BOJ 2822번 점수 계산
정렬

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] scores = new int[9][2];
		int[] check = new int[9];
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		
		for(int i=1; i<9; i++) {
			scores[i][0] = i;
			scores[i][1] = Integer.parseInt(br.readLine());
		}
			
		Arrays.sort(scores, (s1,s2) -> s1[1]-s2[1]);
		
		for(int i=4; i<9; i++) {
			sum += scores[i][1];
			check[scores[i][0]]++;
		}
		
		for(int i=0; i<9; i++) {
			if(check[i] != 0)
				sb.append(i).append(' ');
		}
			
		
		System.out.println(sum);
		System.out.print(sb);
		
	}


	
}
