import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
BOJ 1753번 최단 경로
다익스트라 | 그래프 이론 | 우선순위 큐

*/

public class Main {

	static int V;
	static int E;
	static int start;
	static StringBuilder sb;
	static List<Road>[] arr;
	static int[] min;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		arr = new ArrayList[V+1];
		min = new int[V + 1];

		Arrays.fill(min, Integer.MAX_VALUE);


		for (int i = 0; i <= V; i++) {
			arr[i] = new ArrayList<Road>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[s].add(new Road(des, w));

		}

		dijkstra();

		
		for (int i = 1; i <= V; i++) {

			if (min[i] == Integer.MAX_VALUE) {
				sb.append("INF");
			} else {
				sb.append(min[i]);
			}

			sb.append('\n');
		}

		System.out.print(sb);

	}

	
	static void dijkstra() {
		PriorityQueue<Road> q = new PriorityQueue<>();
		boolean[] flag = new boolean[V+1];

		q.add(new Road(start,0));

		while (!q.isEmpty()) {
			Road point = q.poll();  //가장 거리가 짧은 정점부터 선택!
			int des = point.getDes();
			int w = point.getW();

			if (min[des] < w || flag[des]) continue;
			
			flag[des] = true;
			min[des] = Math.min(min[des], w);

			
			for (int i = 0; i < arr[des].size(); i++) {
				int inputDes = arr[des].get(i).getDes();
				int inputW = arr[des].get(i).getW() + w;

				if (inputW < min[inputDes]) {
					q.offer(new Road(inputDes, inputW));
				}

			}

		}

	}

}

class Road implements Comparable<Road>{

	private int des;
	private int w;

	Road(int x, int y) {
		this.des = x;
		this.w = y;
	}

	int getDes() {
		return des;
	}

	int getW() {
		return w;
	}
	
	@Override
	public int compareTo(Road o) {
		return this.w - o.w;
	}

}
