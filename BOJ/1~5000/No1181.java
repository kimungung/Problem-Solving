import java.io.*;
import java.util.*;

/*
BOJ 1181번 단어 정렬
sort
사용한 방법보다, Comparator을 새로 정의해서 조건을 정해주는 쪽이 더 효율적이다.

(ex)
new Comparator<String>() {
			public int compare(String s1, String s2) {
				// 단어 길이가 같을 경우 
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} 
				// 그 외의 경우 
				else {
					return s1.length() - s2.length();
				}
			}
		}

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		int flag = 0;
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0; i<n; i++)
			arr.add(br.readLine());
		
		//사전순으로 정렬
		Collections.sort(arr);
		
		//길이순으로 재정렬
		for(int i=1; i<51; i++) {
			
			for(int j=flag; j<arr.size(); j++) {

				if(arr.get(j).length() == i) {
					String str = arr.get(j);
					//arr.removeAll(Arrays.asList(str)); //아래보다 메모리↓ 시간↑
					arr.removeIf(s -> s.equals(str)); //위보다 메모리↑ 시간↓
					arr.add(flag, str);
					sb.append(arr.get(flag)+"\n");
				}
				
			}
			
		}
		
		System.out.print(sb.toString());

	}

}
