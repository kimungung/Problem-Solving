import java.io.*;
import java.util.Arrays;

/*
BOJ 2108번 통계학
정렬
수의 범위가 크지 않으므로, arr를 만들어 구하는 것이 더 빠르다.
*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringBuilder sb = new StringBuilder("");
		double sum = 0;

		int count = 1;
		int max = -4000;
		int min = 4000;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		Arrays.sort(arr);
		boolean check = false;
		int answer = n>1 ? arr[1]: arr[0];
		
		//최빈값 answer을 찾는다.
		for(int i=0; i<n-1; i++) {
			int duplicateNum = 1;
			
			while(i<n-1 && arr[i+1] == arr[i]) {
				duplicateNum++;
				i++;
				if(count < duplicateNum) {
					answer = arr[i];
					count = duplicateNum;
					check = false;
				}else if(count == duplicateNum && !check) {
					answer = arr[i];
					check = true;
				}
			}
			
		}
			
		sb.append(Math.round((sum/n)*10/10.0)+"\n");
		sb.append(arr[n/2]+"\n");
		sb.append(answer+"\n");
		sb.append(max-min);
		
		System.out.print(sb);
		
	}

}
