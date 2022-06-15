import java.io.*;
import java.util.*;

/*
BOJ 11399번 ATM
정렬, OS 스케줄러, Greedy 알고리즘

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] time = new int[n];
		int answer = 0;
		
		for(int i=0; i<n; i++)
			time[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(time);
		
		for(int i=0; i<n; i++) {
			answer += (time[i]*(n-i));	
		}
		
		System.out.println(answer);
		
	}

}
