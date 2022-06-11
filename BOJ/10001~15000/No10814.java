import java.io.*;
import java.util.*;

/*
BOJ 10814번 나이순 정렬

compareTo 함수를 재정의 하여 정렬.
나이의 범위가 정해져있으므로, StringBuilder 배열을 이용하는 방법도 있다.

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Person> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			
			arr.add(new Person(Integer.parseInt(str[0]), str[1]));
		}
		
		Collections.sort(arr);
		
		for(Person p: arr) {
			p.printInfo();
		}

	}
	
	
	public static class Person implements Comparable<Main.Person>{
		
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		public int compareTo(int age) {
			return this.age - age;
		}
		
		public void printInfo() {
			System.out.println(this.age+" "+this.name);
		}

		@Override
		public int compareTo(Main.Person o) {
			return this.age - o.age;
		}
		
	}

}
