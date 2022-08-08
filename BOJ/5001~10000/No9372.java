import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 9372번 상근이의 여행
그래프 이론 | 트리
BFS로 풀이할 수도 있다.
*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		while(caseNum-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
			}
			
			//최소 스패닝 트리의 성질을 이용
			sb.append(N-1).append('\n');
		}
		
		
		System.out.print(sb);
		
	}


}
