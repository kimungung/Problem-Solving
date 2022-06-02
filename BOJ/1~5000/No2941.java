import java.io.*;

/*

BOJ 2941번 크로아티아 알파벳
최대한 규칙을 찾아 단순히 표현하는 게 중요.
사실상 파서와 비슷하다는 생각도 든다.

*/

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		System.out.println(checkAlpha(arr));		

	}

	
	static int checkAlpha(char[] arr) {
		int length = 0;
		StringBuilder str = new StringBuilder("");
		
		for(int i=0; i<arr.length; i++) {
			
			if(str.length() == 0) {
				
				if(i == arr.length-1) length++;
				else {
					
					switch(arr[i]) {
					
					case 'c': 
					case 'd': 
					case 'l':
					case 'n':
					case 's':
					case 'z': str.append(arr[i]); break;
					default: length++;
					
					}					
				}
				
			}else {
				str.append(arr[i]);
				
				switch(str.toString()) {
				
				case "c=":
				case "c-":
				case "d-":
				case "lj":
				case "nj":
				case "s=":
				case "z=": length++; break;
				case "dz": 
					if(i < arr.length-1) {
						if(arr[i+1] == '=') {
							length++; i++;
						}else {
							length++; i--;
						}
					}else { 
						length++; i--; 
					}
					break;
				default: length++; i--; break;
				
				}
				
				str.setLength(0);
			}

		}
		
		return length;
		
	}

}
