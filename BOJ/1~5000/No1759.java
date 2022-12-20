import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
BOJ 1759번 암호 만들기
조합론 | Bruteforce


*/

public class Main {

	static int L;
	static int C;
	static char[] arr;
	static char[] ansArr;
	static StringBuilder sb;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		ansArr = new char[L];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		pw(0,0);

		
		System.out.print(sb);

	}


	static void pw(int start, int leng) {
		
		
		if(leng == L) {
			boolean check = false;
			int vow = 1;
			int cons = 2;
			
			for(int i=0; i<L; i++) {
				char a = ansArr[i];
				
				if(checkVow(a)) {
					vow--;
				}else {
					cons--;
				}
				
				if(vow <= 0 && cons <=0) {
					check = true;
					break;
				}
				
			}
			
			if(check) {
				
				for(char c: ansArr)
					sb.append(c);
				
				sb.append('\n');
			}
			
		}else {
			
			for(int i=start; i<C; i++) {		
				ansArr[leng] = arr[i];
				pw(i+1,leng+1);				
			}
			
		}
		
		
		
	}
	
	
	static boolean checkVow(char a) {
		
		if(a == 'a' || a == 'i' || a == 'o' || a == 'u' || a == 'e')
			return true;
		else return false;
	}


}
