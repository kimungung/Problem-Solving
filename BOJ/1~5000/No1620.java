import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 1620번 나는야 포켓몬 마스터 이다솜
해시를 사용한 집합과 맵  | Binary Search
String을 Key로.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] pokemon = new String[n];
		String[][] sortArr = new String[n][2];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			pokemon[i] = input;
			sortArr[i][0] = input;
			sortArr[i][1] = Integer.toString(i);
		}
		
		Arrays.sort(sortArr, (s1, s2) -> (s1[0].compareTo(s2[0])));
		
		for(int i=0; i<m; i++) {
			String input = br.readLine();
			int num = getNum(input);
			
			if(num != 0) {
				//번호일 경우 찾는 법
				sb.append(pokemon[num-1]).append('\n');
			}else {
				//값으로 찾는 법
				sb.append(findPokemon(sortArr, input)+1).append('\n');
				
			}
			
		}
		
		System.out.print(sb);

	}
	
	static int findPokemon(String[][] arr, String name) {
		int min = 0;
		int max = arr.length-1;
		int mid;
		
		while(min <= max) {
			mid = (min+max) >> 1;
			int check = arr[mid][0].compareTo(name);
			
			if(check == 0) {
				return Integer.parseInt(arr[mid][1]);
			}else if(check < 0) {
				min = mid+1;
			}else {
				max = mid-1;
			}
			
		}
		
		return -1;
	}

	
	static int getNum(String str) {
		
		if(str == null) {
			return 0;
		}
		
		try {
			int num = Integer.parseInt(str);
			
			return num;
		}catch (Exception e) {
			return 0;
		}

	}
	
}
