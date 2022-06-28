import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
BOJ 11723번 집합
ArrayList

BitSet쪽이 더 빠르다. or boolean[]

*/

public class Main {
	
	static StringBuilder answer = new StringBuilder();
	static ArrayList<Integer> S = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=1; i<=20; i++)
			S.add(i);
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			func(arr, str);
		}
		
		System.out.print(answer);
	
	}
	
	
	static void func(ArrayList<Integer> arr, String[] str) {
		
		
		switch(str[0].charAt(0)) {
		
		case 'a':
			if(str[0].equals("all")) {
				arr.clear();
				arr.addAll(S);
			}else {
				int a = Integer.parseInt(str[1]);
				if(!arr.contains(a))
					arr.add(a);
			}
			break;
		case 'r':
			arr.remove(Integer.valueOf(Integer.parseInt(str[1])));
			break;
		case 'c':
			int b = Integer.parseInt(str[1]);
			if(arr.contains(b))
				answer.append("1").append('\n');
			else 
				answer.append("0").append('\n');
			break;
		case 'e':
			arr.clear();
			break;
		case 't':
			int c = Integer.parseInt(str[1]);
			if(arr.contains(c))
				arr.remove(Integer.valueOf(c));
			else 
				arr.add(c);
			break;
		default: System.out.print("Check Input!");
		
		}
		
	}
	
}
