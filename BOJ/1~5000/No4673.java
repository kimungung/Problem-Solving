/*

BOJ 4673번 셀프 넘버
10000 크기의 Array를 만들어 체크하는 것이 조금 더 효율적이다.

*/

public class Main {

	public static void main(String[] args){
		StringBuilder sb = new StringBuilder("1");
		
		for(int i=2; i<=10000; i++) {
			boolean check = true;
			if(i <= 100) {
				for(int j=i-18; j<i; j++) {
					if(i == selfNumber(j)) {
						check = false;
						break;
					}
				}	
			}else if(i <= 1000) {
				for(int j=i-27; j<i; j++) {
					if(i == selfNumber(j)) {
						check = false;
						break;
					}
				}	
			}else {
				for(int j=i-36; j<i; j++) {
					if(i == selfNumber(j)) {
						check = false;
						break;
					}
				}
			}
			
			if(check) sb.append("\n"+i);
			
		}
		
		System.out.print(sb.toString());
		
	}
	
	public static int selfNumber(int n) {
		int answer = n;
		char[] arr = Integer.toString(n).toCharArray();
		
		for(int value: arr)
			answer += value-'0';
		
		return answer;
		
	}
	

}
