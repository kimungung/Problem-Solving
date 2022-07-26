import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
BOJ 8979번 올림픽
구현 | 정렬
전체를 정렬하는 것보다도, 등수를 알고자 하는 국가(=번호)보다 등수가 높은 나라만을 카운트하는 것이 빠르다.

*/

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		LinkedList<Country> arr = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr.add(new Country(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			
		}
		
		Collections.sort(arr, new Comparator<Country>(){
			
			@Override
			public int compare(Country o1, Country o2) {
				int big = -1;
				int small = 1;
				
				if(o1.gold > o2.gold) {
					return big;
				}else if(o1.gold < o2.gold) {
					return small;
				}else {
					
					if(o1.silver > o2.silver) {
						return big;
					}else if(o1.silver < o2.silver) {
						return small;
					}else {
						
						if(o1.bronze > o2.bronze) {
							return big;
						}else if(o1.bronze < o2.bronze) {
							return small;
						}else {
							
							if(o1.num == m)
								return big;
							else
								return small;
							
						}
						
					}
					
				}
				
			}
			
			
		});

		for(int i=0; i<n; i++) {
			
			if(arr.get(i).num == m) {
				System.out.print(i+1);
				return;
			}
			
		}
		
	}

}


class Country{
	
	int num;
	int gold;
	int silver;
	int bronze;
	
	public Country(int num, int gold, int silver, int bronze) {
		this.num = num;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	
}
