import java.io.*;
import java.util.StringTokenizer;

/*
BOJ 1021번 회전하는 큐
덱
덱을 쓰는게 더 단순하다.
*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		int answer = 0;
		
		for(int i=0; i<=n; i++)
			arr[i] = i;
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int start = 1;
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			answer += search(start, arr, num);
			arr[num] = 0;
			
			if(i == n-1) break;
			
			while(arr[num] == 0) {
				num++;
				
				if(num >= arr.length)
					num %= arr.length;
				
			}
			
			start = num;
			
		}
			
		
		System.out.print(answer);
		
	}
	
	
	static int search(int start, int[] arr, int num) {
		int answerR = 0;
		int answerL = 0;
		int startPoint = start;
		
		//오른쪽으로 회전할 경우
		while(arr[startPoint] != num) {
			
			startPoint++;
			
			if(startPoint >= arr.length)
				startPoint %= arr.length;
			
			if(arr[startPoint] != 0)
				answerR++;
					
		}
		
		startPoint = start;
		
		//왼쪽으로 회전할 경우
		while(arr[startPoint] != num) {
			
			startPoint--;
			
			if(startPoint < 0)
				startPoint = arr.length-1;
			
			if(arr[startPoint] != 0)
				answerL++;
					
		}
		
		
		return Math.min(answerR, answerL);
	}

}
