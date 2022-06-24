import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 9095번 1,2,3 더하기
DP | 수학

*/

public class Main {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		

		for(int i=0; i<n; i++) {
			answer.append(count(Integer.parseInt(br.readLine()))).append('\n');
		}
		
		System.out.print(answer);
	}
	
	
	static int count(int num) {
		
		if(arr[num] != 0)
			return arr[num];
		else {
			
			return arr[num] = (count(num-1)+ count(num-2)+count(num-3));
		}
		
	}

}
