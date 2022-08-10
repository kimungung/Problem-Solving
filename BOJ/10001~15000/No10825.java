import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
BOJ 10825번 국영수
정렬

*/

public class Main {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Student> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int k = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			arr.add(new Student(name,k,e,m));
			
		}
		
		Collections.sort(arr);

		
		for(int i=0; i<n; i++)
			sb.append(arr.get(i).getName()).append('\n');
		
		
		System.out.print(sb);
	}


}

class Student implements Comparable<Student>{
	
	String name;
	int korean;
	int english;
	int math;
	
	
	Student(String n, int k, int e, int m){
		name = n;
		korean = k;
		english = e;
		math = m;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public int compareTo(Student o) {
		
		
		if(this.korean < o.korean) {
			return 1;
		}else if(this.korean == o.korean) {
			
			if(this.english > o.english) {
				return 1;
			}else if(this.english == o.english) {
				
				if(this.math < o.math) {
					return 1;
				}else if(this.math == o.math) {
					return this.name.compareTo(o.name);
				}
				
			}
		}
		
		return -1;

	}
	
}
