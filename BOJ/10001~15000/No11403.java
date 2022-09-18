import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
BOJ 11403번 경로찾기
그래프 탐색 | 플로이드 와샬
방향성 있는 그래프의 경로 찾기 기본

*/

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] arr = new ArrayList[n];	
		
		
		//가중치 없는 방향 그래프
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new ArrayList<Integer>();
			
			
			for(int j=0; j<n; j++) {
				int v = Integer.parseInt(st.nextToken());
				
				if(v == 1)
					arr[i].add(j);
			}
			
		}
	
		
		for(int i=0; i<n; i++) {			
			for(int j=0; j<n; j++) {			
				if(arr[i].contains(j)) {
					sb.append(1);
				}else{
					search(arr,i,j);
				}				
				sb.append(' ');
			}
			
			sb.append('\n');			
		}
		
		
		System.out.print(sb);
		
	}
	
	
	static void search(ArrayList<Integer>[] arr, int x, int y) {		
		Queue<Integer> q = new LinkedList<>();
		boolean[][] flag = new boolean[n][n];
		
		q.offer(x);
		
		while(!q.isEmpty()) {
			int point = q.poll();
			int length = arr[point].size();
			
			if(arr[point].contains(y)) {
				sb.append(1); return;
			}
			
			
			for(int i=0; i<length; i++) {
				if(!flag[point][i]) {
					flag[point][i] = true;
					q.offer(arr[point].get(i));
				}
				
			}
			
			
		}

		
		sb.append(0);
		
	}

	
}
