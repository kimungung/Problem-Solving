import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
BOJ 7785번 회사에 있는 사람
해시를 이용한 집합과 맵  | TreeMaP

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<String,String> m = new TreeMap<>((s1,s2) -> s2.compareTo(s1));
		StringBuilder sb = new StringBuilder();
		
		while(N-- > 0) {
			String[] arr = br.readLine().split(" ");
			
			if(arr[1].equals("enter")) {
				m.put(arr[0], arr[0]);
			}else {
				m.remove(arr[0]);
			}
			
		}
		
		Set<Map.Entry<String,String>> e = m.entrySet();
		
		for(Map.Entry<String, String> temp : e) {
			sb.append(temp.getKey()).append('\n');
		}
		
		System.out.print(sb);
		
	}

}
