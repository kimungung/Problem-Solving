import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
BOJ 11004번 K번째 수
정렬

*/

public class Main {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int max = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);
		int[] arr = new int[max];
		str = br.readLine().split(" ");
		
		for(int i=0; i<max; i++)
			arr[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(arr);
		
		System.out.println(arr[n-1]);
		
	}
	
}
