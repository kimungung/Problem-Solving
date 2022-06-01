import java.io.*;

/*

BOJ 1316번 그룹 단어 체커
문자열 처리
알파벳 수만큼의 boolean arr를 만들어 체크하는 것이 조금 더 효율적이다.

*/

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			char[] arr = br.readLine().toCharArray();
			answer++;
			
			if(arr.length == 1 || arr.length == 2) continue;
			
			for(int j=2; j<arr.length; j++) {
				if(arr[j] != arr[j-1]) {
					if(checkChar(arr[j], arr, j)) {
						answer--; break;
					}
				}
			}
			
		}
		
		System.out.println(answer);

	}
	
	static boolean checkChar(char c, char[] arr, int n) {
		
		for(int i =0; i<n-1; i++) {
			if(arr[i] == c) return true;
		}
		
		return false;
		
	}

}
