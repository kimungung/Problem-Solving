import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
BOJ 18870번 좌표 압축
정렬 | Treemap | HashMap
HashMap쪽이 조금 더 빠르다.

*/

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] answer = new int[n];
		
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			arr[i] = input;
			answer[i] = input;
		}
		
		Arrays.sort(arr);
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int countV = 0;
		
		for(int i=0; i<n; i++) {
			int key = arr[i];
			
			if(!map.containsKey(key))
				map.put(key, countV++);
			
		}

		for(int i: answer) {
			bw.write(Integer.toString(map.get(i)));
			bw.write(' ');
		}
		
		bw.flush();
		bw.close();
		
	}



}
