import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
BOJ 2456번 나는 학급회장이다
구현 | 많은 조건 분기
예외를 잘 생각할 것.

*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] sum = new int[3];
		int[][] count = new int[3][3];
		
		while(num -- > 0) {
			String[] arr = br.readLine().split(" ");
			
			for(int i=0; i<3; i++) {
				int n = Integer.parseInt(arr[i]);
				
				sum[i] += n;
				count[i][n-1]++;
			}

		}
		
		int ans = findAns(count,sum, 0, 1);
		
		if(ans < 0 ) {
			ans = findAns(count, sum, -ans-1,2);

			//3번 후보와 1,2번 후보를 견줄 이유가 없는 케이스일 때
			if(ans != 2)
				ans = -1;
			
		}else {
			ans = findAns(count, sum, ans,2);
		}
		
		System.out.print(ans<0 ? 0+" "+sum[-ans-1] : ans+1+" "+sum[ans]);	

	}
	
	
	static int findAns(int[][] count, int[] sum, int a, int b) {
		int answerNum = 0;
				
		if(sum[a] > sum[b]) {	
			answerNum = a;			
		}else if(sum[a] < sum[b]) {			
			answerNum = b;		
		}else {
			
			if(count[a][2] > count[b][2]) {
				answerNum = a;
			}else if(count[a][2] < count[b][2]) {
				answerNum = b;
			}else {
				
				if(count[a][1] > count[b][1]) {
					answerNum = a;
				}else if(count[a][1] < count[b][1]) {
					answerNum = b;
				}else {	
					answerNum = -a-1;					
				}
				
			}
			
		}
		
		return answerNum;
		
	}

}
