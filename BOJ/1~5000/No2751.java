import java.io.*;
import java.util.*;

/*

BOJ 2751번 수 정렬하기2
정렬 문제. 
입력값 중 중복이 없음을 이용하여 boolean[]을 이용하는 게 조금 더 빠르다.

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++)
			arr.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(arr);
		
		for(int i: arr)
			sb.append(i+"\n");
		
		System.out.println(sb.toString());
	}

		
}
