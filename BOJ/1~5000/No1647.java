import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*

BOJ 1647번 도시 분할 계획
최소 스패닝 트리(MST) 문제의 변형
최소 스패닝 트리를 구한 후, 가장 가중치가 큰 간선을 제거하면 된다.
Prim 알고리즘을 사용해 풀었다.

*/

public class Main {

	static int houseNum;
	static int roadNum;
	static ArrayList<Road>[] arr;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		houseNum = Integer.parseInt(st.nextToken());
		roadNum = Integer.parseInt(st.nextToken());
		arr = new ArrayList[houseNum+1];
		
		for(int i=0; i<=houseNum; i++) {
			arr[i] = new ArrayList<Road>();
		}
		
		
		for(int i=0; i<roadNum; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[n].add(new Road(end,cost));
			arr[end].add(new Road(n,cost));
			
		}
		
		
		System.out.print(solve());

	}

	
	//전체 연결의 최솟값을 구한 후, 가장 cost가 큰 길을 잘라서 마을을 만든다. (즉, 합-max를 한다.)
	static int solve() {
		PriorityQueue<Road> q = new PriorityQueue<>();
		boolean[] check = new boolean[houseNum+1];
		int answer = 0;
		int max = 0;
		
		for(int i=0; i<arr[1].size(); i++)
			q.add(arr[1].get(i));
		
		check[1] = true;
		check[0] = true;
		
		while(!q.isEmpty()) {
			Road r = q.poll();
			
			if(check[r.end]) continue;
			
			for(int i=0; i<arr[r.end].size(); i++) {
				Road nextR = arr[r.end].get(i);
				
				if(!check[nextR.end])
					q.add(nextR);
			}
				
			answer += r.cost;
			max = Math.max(r.cost, max);
			check[r.end] = true;
			
			if(checkEnd(check)) {
				break;
			}
				
		}
		
		return answer-max;
		
	}
	
	
	static boolean checkEnd(boolean[] arr) {
		
		for(int i=0; i<arr.length; i++) {
			if(!arr[i])
				return false;
		}
		
		return true;
	}
	


}


class Road implements Comparable<Road>{
	
	int end;
	int cost;
	
	Road(int end, int cost){
		this.end = end;
		this.cost = cost;
	}
	
	
	public int compareTo(Road o) {
		return this.cost - o.cost;
	}
	
	
}
