import java.io.*;
import java.util.*;

/*
BOJ 19699번 소-난다!
백드랙킹 | 에라토스테네스의 체
소수를 미리 걸러낸 후, 백트랙킹 방식으로 전체 수를 탐색해가며 소수 판별.
TreeSet을 사용하지 않고도 풀 수 있다.

*/

public class Main {
	
	static boolean[] check;
	static boolean[] flag;
	static int[] cow;
	static int n;
	static int m;
	static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cow = new int[n];
		flag = new boolean[n];
		set = new TreeSet<>();
		check = new boolean[9001];
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++)
			cow[i] = Integer.parseInt(st.nextToken());
				
		checkPrime();
		checkCow(0,0);
		
		if(set.size() == 0) {
			System.out.print(-1);
			return;
		}
		
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			sb.append(it.next()).append(' ');
		}
			
		
		System.out.print(sb);
		
	}
	
	
	
	static void checkCow(int sum, int num) {
		
		if(num == m) {

			if(!check[sum])
				set.add(sum);
			
			return;
		}			
		
		for(int i=0; i<n; i++) {
			if(!flag[i]) {
				flag[i] = true;
				checkCow(sum+cow[i], num+1);
				flag[i] = false;
			}
			
		}

	}
	
	
	
	static void checkPrime() {
		
		check[0] = check[1] = true;
		
		for(int i=2; i<=Math.sqrt(check.length); i++) {
			
			if(!check[i]) {
				
				for(int j=i*i; j<9001; j +=i)
					check[j] = true;
				
			}
			
		}
		
		
	}

}
