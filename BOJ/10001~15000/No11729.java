import java.io.*;

/*
BOJ 11729번 하노이의 탑 이동 순서
재귀 | 하노이의 탑
*/

public class Main {


	static StringBuilder sb;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		answer = 0;
		

		hanoi(n,1,3,2);
		
		System.out.println(answer);
		System.out.print(sb);
	}
	
	
	static void hanoi(int n, int start, int goal, int mid) {
		
		if(n == 1) {
			sb.append(start).append(' ').append(goal).append('\n');
			answer++;
		}else {
			
			hanoi(n-1,start,mid,goal);
			//sb.append(1,3)을 처리하면 답이 다르게 나온다. 이 차이를 알 것!
			hanoi(1,start,goal,mid); 
			hanoi(n-1,mid,goal,start);
		}
		
	}



}
