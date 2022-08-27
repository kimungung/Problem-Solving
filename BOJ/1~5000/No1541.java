import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
BOJ 1541번 잃어버린 괄호(Greedy | 파싱)

*/

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split("[+-]"); // +로 나누는 건 "\\+"
		String[] op = str.split("[0-9]+");
		ArrayList<Integer> nums = new ArrayList<>();
		int sum = 0;
		
		
		if(arr.length == 1) {
			System.out.print(arr[0]);
			return;
		}
		
		
		for(int i=1; i<op.length; i++) {
			
			sum += Integer.parseInt(arr[i-1]);
			
			if(i == op.length-1) {
				if(op[i].equals("-")) {
					nums.add(sum);
					nums.add(Integer.parseInt(arr[i]));
				}else {
					sum += Integer.parseInt(arr[i]);
					nums.add(sum);
				}
				break;
			}
			
			if(op[i].equals("-")) {
				nums.add(sum);
				sum = 0;
			}
			
		}
		
		sum = nums.get(0);
		
		for(int i=1; i<nums.size(); i++) {
			sum -= nums.get(i);
		}
		
		System.out.print(sum);
		
	}

	


}
