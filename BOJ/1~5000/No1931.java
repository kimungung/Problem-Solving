import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 1931번 회의실 배정
정렬 | 그리디 알고리즘

*/

public class Main {

	static int N;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int answer = 1;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i][0] = a;
			arr[i][1] = b;
		}
		
		Arrays.sort(arr, (s1,s2) -> {
			if(s1[1] == s2[1])
				return s1[0] - s2[0];
			else
				return s1[1] - s2[1];
			
		});
		
		int i=0;
		int j=1;
		
	
		while(j<N) {
			
			if(arr[i][1] <= arr[j][0]) {
				answer++;
				i = j;
				j++;
			}else {
				j++;
			}
			
			
		}

		
		System.out.print(answer);

	}


}
