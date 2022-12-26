import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 15686번 치킨 배달
Bruteforce

*/


public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	static ArrayList<int[]> chickens;
	static LinkedList<int[]> q;
	static int answer;
	static boolean[] flag;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		chickens = new ArrayList<>();
		q = new LinkedList<>();
		answer = Integer.MAX_VALUE;
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 1) q.add(new int[]{i,j});
				else if(num == 2) chickens.add(new int[] {i,j});
				
				arr[i][j] = num;
			}
			
		}
		
		flag = new boolean[chickens.size()];
		
		if(chickens.size() == M) {
			bfs(chickens);
		}else { //고른 경우의 수마다 호출
			
			setGoals(0,0);
			
		}
		
		
		
		System.out.print(answer);

	}
	
	static void setGoals(int depth, int num){
		
		if(depth == M) {
			ArrayList<int[]> goals = new ArrayList<>();

			for(int i=0; i<flag.length; i++) {
				if(flag[i]) {
					goals.add(chickens.get(i));
				}
					
			}
			
			bfs(goals);
			
		}else {

			for(int i=num; i<chickens.size(); i++) {
				flag[i] = true;
				setGoals(depth+1, i+1);
				flag[i] = false;
				
			}
		}

		
	}
	
	
	static void bfs(ArrayList<int[]> goal) {
		int sum = 0;
		
		
		for(int i=0; i<q.size(); i++) {
			int[] a = q.get(i);
			int x = a[0];
			int y = a[1];
			int min = Integer.MAX_VALUE;
			
			
			for(int j=0; j<goal.size(); j++) {
				int[] b =goal.get(j);
				int count = Math.abs(b[0]-x)+Math.abs(b[1]-y);
				
				if(count < min)
					min = count;					
			}			
			sum += min;
			
		}
		
		if(sum < answer)
			answer = sum;
		
	}
	
	
}
