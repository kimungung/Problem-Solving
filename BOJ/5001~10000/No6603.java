import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 6603번 로또
백트랙킹 | 재귀

*/

public class Main {

	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			if(num == 0) break;
			
			int[] arr = new int[num];
			boolean[] flag = new boolean[num];
			
			for(int i=0; i<num; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			lotto(num, 0, arr, flag, 0);
			sb.append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	
	static void lotto(int max, int startNum, int[] arr, boolean[] flag, int count) {
		
		if(count == 6) {
			
			for(int i=0; i<max; i++) {
				
				if(flag[i]) {
					sb.append(arr[i]).append(' ');
				}
				
			}
			sb.append('\n');
			return;
		}
		
		
		for(int i=startNum; i<max; i++) {
			
			if(!flag[i]) {
				flag[i] = true;
				lotto(max, i, arr, flag, count+1);
				flag[i] = false;
			}
			
		}
		
	}

}
