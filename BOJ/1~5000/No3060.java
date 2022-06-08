import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

BOJ 3060번 욕심쟁이 돼지
수학, 시뮬레이션 문제.
결국 하루가 지날수록 돼지들이 요구하는 사료량은 전날에 4배가 된다.
이를 통해 코드와 연산을 더 간단히 할 수 있다.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int feed = N;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr= new int[6];
			int[] nextArr = new int[6];
			int day = 1;
			
			for(int i=0; i<6; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				feed -= arr[i];
			}
			
			while(feed >= 0) {
				feed = N;
				
				for(int i=0; i<6; i++) {
					nextArr[i] = arr[i]+arr[(i+3)%6]+arr[(i+1)%6]+arr[(i+5)%6];
					feed -= nextArr[i];
				}

				for(int i=0; i<6; i++) {
					arr[i] = nextArr[i];
				}
				
				day++;
			}
			
			
			sb.append(day).append('\n');
			
		}
		
		System.out.print(sb);
		
	}

}
