import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 1011번 Fly to the Alpha Centauri
표를 그려가며 규칙을 찾으면 쉽다. | 수학

*/

public class Main {


	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		
		while(num-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dis = y-x;
			int max = (int)Math.sqrt(dis);
			
			if(max == Math.sqrt(dis)) {
				sb.append(2*max-1).append('\n');
			}else if(dis <= max*max+max) {
				sb.append(2*max).append('\n');
			}else {
				sb.append(2*max+1).append('\n');
			}
			
			
		}
		
		System.out.print(sb);

	}

	
	
}
