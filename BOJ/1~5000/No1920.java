import java.io.*;
import java.util.Arrays;

/*
BOJ 1920번 수 찾기
이진 탐색.
정렬을 했다면 이진 탐색으로 효율을 높일 수 있다.
map으로 푸는 것이 더 효율적이다.

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str1 = br.readLine().split(" ");
		int[] arrN = new int[n];
		int m = Integer.parseInt(br.readLine());
		String[] str2 = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder("");
		
		
		for(int i=0; i<n; i++)
			arrN[i] = Integer.parseInt(str1[i]);
			
		Arrays.sort(arrN);

		
		for(int i=0; i<m; i++) {
			int a = Integer.parseInt(str2[i]);
			
			if(a < arrN[0] || a > arrN[n-1] ) {
				sb.append("0\n");
			}else {
				
				sb.append(binarySearch(arrN,a)+"\n");
				
			}

		}
		
		System.out.print(sb);

	}
	
	static int binarySearch(int[] arr, int a) {
		int min = 0;
		int max = arr.length-1;
		int mid;
		
		while(min <= max) {
			mid = (min+max) >> 1;
			
			if(a == arr[mid]) {
				return 1;
			}else if(a < arr[mid]) {
				max = mid -1;
			}else {
				min = mid+1;
			}

		}
		return 0;
		
	}

}
