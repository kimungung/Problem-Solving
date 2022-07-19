import java.io.*;
import java.util.*;

/*
BOJ 1966번 프린터 큐
큐 | 시뮬레이션
조금 복잡하게 풀었다. array를 이용해 그때그때의 max를 찾는 방법이 조금 더 간단하다.
*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arrLength = Integer.parseInt(st.nextToken());
			int doc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			LinkedList<ArrayList<Integer>> arr = new LinkedList<>();
			int[] count = new int[10];
			int checkNum = 0;
			
			for(int j=0; j<arrLength; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(j == doc) {
					arr.add(new ArrayList<Integer>(Arrays.asList(input,1)));
					checkNum = input;
				}					
				else
					arr.add(new ArrayList<Integer>(Arrays.asList(input)));
				count[input]++;
			}
			
			
			sb.append(find(arr, count, checkNum)).append('\n');
			
		}
		
		
		System.out.print(sb);

	}
	
	
	static int find(LinkedList<ArrayList<Integer>> arr, int[] count, int checkNum) {
		int answer = 0;

		
		for(int i=9; i>0; i--) {
			
			if(count[i] == 0)
				continue;
			
			if(i == checkNum) {
				while(arr.peek().size() == 1) {
					
					if(arr.peek().get(0) == i) {
						answer++;
					}
					arr.poll();

				}
				return answer+1;
			}else {
				
				while(count[i] != 0) {
					
					if(arr.peek().get(0) == i) {
						answer++;
						count[i]--;
						arr.poll();
					}else {
						arr.add(arr.poll());
					}
					
				}
			}

		}
		
		return answer;
		
	}

}
