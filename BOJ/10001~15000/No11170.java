import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 11170번 0의 개수
프루트포스, 수학
미리 각 숫자에서의 0의 개수를 구해 저장하는 것이 보다 효율적이다.
*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int answer = 0;
			
			for(int i=a; i<=b; i++) {
				String str = Integer.toString(i);
				
				for(int j=0; j<str.length(); j++)
					if(str.charAt(j) == '0')
						answer++;
				
			}
			
			sb.append(answer).append('\n');
			
		}

		System.out.print(sb);
		
	}

}
