import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 1946번 신입사원
정렬 | 그리디
1차 배열로 정렬 없이 푸는 방법이 더 단순하고 간단하다.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		while(n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			int[][] arr = new int[num][2];
			int answer = 1;
			StringTokenizer st;
			
			
			for(int i=0; i<num; i++) {
				st = new StringTokenizer(br.readLine());
				
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, (s1, s2) -> (s1[0]-s2[0]));
			
			int max = arr[0][1]; 
			
			//면접 성적만 비교하기
			for(int i=1; i<num; i++) {
				int score = arr[i][1];
				
				if(score < max) {
					answer++;
					max = score;
				}
				
			}
			
			sb.append(answer).append('\n');
			
		}
		
		
		System.out.print(sb);

	}
	

}
