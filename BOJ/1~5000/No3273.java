import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 3273번 두 수의 합
정렬 | 두 포인터
*/

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int num = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			
			for(int j=i+1; j<n; j++) {
				
				if(arr[i]+arr[j] == num) {
					answer++;
				}else if(arr[i]+arr[j] > num) {
					break;
				}	
				
			}

		}
		
		
		
		System.out.print(answer);
		

	}



}
