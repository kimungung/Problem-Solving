import java.io.*;
import java.util.Arrays;

/*
BOJ 1764번 듣보잡
이진 탐색, HashSet, Map
정렬이 돼있다면, 이진 탐색을 사용해 탐색 시간 효율을 높일 수 있는 경우가 많다.

*/

public class Main {

	static String[] arr1;
	static int answer;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		String[] arr2 = new String[m];
		arr1 = new String[n];
		sb = new StringBuilder();
		answer = 0;
		
		for(int i=0; i<n; i++)
			arr1[i] = br.readLine();

		for(int i=0; i<m; i++)
			arr2[i] = br.readLine();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for(int i=0; i<m; i++)
			binarySearch(arr2[i], n);

		
		System.out.println(answer);
		System.out.print(sb);
		
	}
	
	
	static void binarySearch(String str, int num) {
		int min = 0;
		int max = num-1;
		int mid;
		
		while(min <= max){
			mid = (min+max) >> 1;
			int a = arr1[mid].compareTo(str);

			if(a == 0) {
				answer++;
				sb.append(str).append('\n');
				return;
			}else if(a > 0) {
				max = mid-1;
			}else {
				min = mid+1;
			}
			
		}
		
		
	}
	
}
