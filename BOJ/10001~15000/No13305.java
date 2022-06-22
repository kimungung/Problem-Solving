import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 13305번 주유소
Greedy
재귀보다 다른 방법이 효율적이다.

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] dis = new long[n-1];
		long[] cost = new long[n];
		long minCost;
		long disSum = 0;
		long answer = 0;

		
		for(int i=0; i<n-1; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
			disSum += dis[i];
		}
			
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++)
			cost[i] = Integer.parseInt(st.nextToken());
		

//로직 시작
		minCost = cost[0];
		disSum = dis[0];
		
		for(int i=1; i<dis.length; i++) {
			
			if(cost[i] >= minCost) {
				disSum += dis[i];
				answer += disSum*minCost;
				disSum = 0;
			}else {
				answer += disSum*minCost;
				minCost = cost[i];
				disSum = dis[i];
			}
		}
		
		if(disSum != 0) answer += (disSum*minCost);

		System.out.println(answer);
		
	}
	

}
