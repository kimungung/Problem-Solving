import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/*
BOJ 1927번 최소 힙
우선순위 큐
PriorityQueue는 힙 구조로 되어있다. 이를 이용.
직접 구현할 줄 알아야한다.
*/

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(a == 0) {
				if(!pq.isEmpty()) {
					bw.write(pq.poll()+"\n");					
				}else {
					bw.write(0+"\n");
				}

			}else {
				pq.offer(a);
			}
			
		}
		
		bw.flush();
		bw.close();
		
	}


}
