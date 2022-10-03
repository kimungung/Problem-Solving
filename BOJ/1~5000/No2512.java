import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 2512번 예산
이분탐색

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int budget = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int maxNum = 0;
		int sum = 0;
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(arr[i] > maxNum) maxNum = arr[i];
			
			sum += arr[i];
		}
		
		if(sum <= budget) {
			System.out.print(maxNum); return;
		}
		
		
		int min = budget/n;
		int max = maxNum;
		
		while(min <= max) {
			int mid = (min+max)>> 1;
			int money = budget;
			
			for(int i=0; i<n; i++) {
				
				if(arr[i] < mid)
					money -= arr[i];
				else
					money -= mid;
				
			}
			
			if(money < 0) {
				max = mid-1;
			}else if(money == 0) {
				answer = mid;
				break;
			}else {
				answer = mid;
				min = mid+1;
			}
	
		}
		
		System.out.print(answer);
		
		
	}


}
