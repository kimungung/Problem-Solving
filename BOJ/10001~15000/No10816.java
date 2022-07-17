import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 10816번 숫자 카드 2
정렬 | 이진 탐색

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[20000001];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++)
			input[10000000+Integer.parseInt(st.nextToken())]++;
		
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

//코드는 훨씬 간결! 하지만 더 느린 방법
		for(int i=0; i<m; i++) {
			int value = Integer.parseInt(st.nextToken())+10000000;
			
			sb.append(input[value]).append(" ");
		}


/*
		for(int i=0; i<m; i++) {
			int value = card[i]+10000000;
			
			if(input[value] > 0)
				sb.append(input[value]).append(' ');
			else
				sb.append(0).append(' ');
			
		}
*/
		
		System.out.print(sb);

	}

}
