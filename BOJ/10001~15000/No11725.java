import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 11725번 트리의 부모 찾기
dfs | bfs | 연결 시르트로 그래프 구현

*/

public class Main {

	static int n;
	static ArrayList<LinkedList<Integer>> arr;
	static int[] answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		answer = new int[n+1];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<=n; i++)
			arr.add(new LinkedList<Integer>());
		
		for(int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		
		dfs(1);
			
		
		for(int i=2; i<=n; i++) {
			sb.append(answer[i]);
			sb.append('\n');
		}
		
		System.out.print(sb);
		
	}
	
	
	
	static void dfs(int start) {
		
		
		while(!arr.get(start).isEmpty()) {
			int num = arr.get(start).poll();
			
			if(answer[num] == 0) {
				answer[num] = start;
				dfs(num);
			}
			
		}
		
		
	}


}
