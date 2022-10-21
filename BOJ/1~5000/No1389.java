import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 1389번 케빈 베이컨의 6단계 법칙
그래프 탐색 | BFS | 폴로이드-와샬

*/

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int min;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		min = Integer.MAX_VALUE;
		answer = 0;
		
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
			
		}
		
		
		for(int i=1; i<=N; i++)
			count(i);
		
		
		System.out.print(answer);

	}
	
	
	public static void count(int user) {
		int sum = 0;
		
		for(int i=1; i<=N; i++) {
			
			if(i == user) continue;
			
			sum += bfs(user,i);
		}
		
		if(sum < min) {
			min = sum;
			answer = user;
		}
		
	}
	
	
	public static int bfs(int user, int friend) {
		LinkedList<Integer> q = new LinkedList<>();
		boolean[] flag = new boolean[N+1];
		int count = 0;
		
		q.offer(user);
		flag[user] = true;
		
		while(!q.isEmpty()) {
			int leng = q.size();
		
			count++;
			
			for(int i=0; i<leng; i++) {
				int x = q.poll();
				
				if(arr[x][friend] == 1) {
					return count;
				}
				
				for(int j=1; j<=N; j++) {
					
					if(arr[x][j] == 1 && !flag[j]) {
						q.offer(j);
						flag[j] = true;
					}
					
				}
				
			}
		}
		
		return 0;
		
	}



}
