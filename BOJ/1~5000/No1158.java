import java.io.*;
import java.util.*;

/*
BOJ 1158번 요세푸스 문제
환형 큐 문제

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);
		ArrayList<Integer> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder("<");
		int base = 0;
		
		for(int i=1; i<=n; i++)
			arr.add(i);
		
		while(arr.size() > 1) {
			base += (k-1);
			int i = base;
			
			if(i >= arr.size())
				i %= arr.size();
			
			sb.append(arr.get(i)+", ");
			base = i;
			arr.remove(i);

		}
		
		sb.append(arr.get(0)+">");
		
		System.out.print(sb);
		
	}

}
