import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

BOJ 2810번 컵홀더
구현 문제.
사용한 방법보다는 컵홀더의 개수를 세는 데에 집중하여 푸는 것이 효율이 더 좋다.
컵홀더의 수가 사람수보다 많다면, 사람 수를 출력하고
컵홀더의 수가 더 적다면 컵홀더의 수를 출력하면 되기 때문.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] holder = new int[N + 2];
		int answer = 0;
		String str = br.readLine();
		boolean couple = false;

		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == 'L') {

				if (couple) {
					holder[i] = -1;
					couple = false;
				} else {
					couple = true;
				}

			}
		}
		
		for(int i=0; i<N; i++) {
			if(holder[i] != -1) {
				answer++;
			}else if(holder[i+1] != -1) {
				answer++;
				holder[i+1] = -1;
			}
			
		}
		
		System.out.print(answer);

	}

}
