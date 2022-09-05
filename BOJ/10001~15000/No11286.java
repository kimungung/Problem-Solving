import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
BOJ 11286번 절댓값 힙
우선순위 큐

*/

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<>((s1,s2) ->{
			if(s1.value == s2.value)
				return s1.check - s2.check;
			else
				return s1.value - s2.value;
		});
		
		
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(a == 0) {
				if(!pq.isEmpty()) {
					Point  p = pq.poll();
					
					if(p.check == 0) {
						sb.append((p.value)*-1);
					}else {
						sb.append(p.value);
					}
						
				}else {
					sb.append(0);
				}
				sb.append('\n');
			}else {
				
				if(a > 0) {
					pq.add(new Point(a,1));
				}else {
					pq.add(new Point(Math.abs(a),0));
				}					
				
			}
			
		}
		
		System.out.print(sb);
		
	}


}

class Point{
	
	public int value;
	public int check;
	
	
	public Point(int value, int check) {
		this.value = value;
		this.check = check;
	}
	
	

}
