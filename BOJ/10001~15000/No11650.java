import java.io.*;
import java.util.*;

/*
BOJ 11650번 좌표 정렬하기
Arrays.sort()를 사용하는 것도 가능하다.

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> arr =new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");

			arr.add(new Point(Integer.parseInt(str[0]), Integer.parseInt(str[1])));			
		}
		
		Collections.sort(arr, new Comparator<Point>(){
			
			public int compare(Point p1, Point p2) {
				if(p1.x == p2.x) {
					return p1.y - p2.y;
				}else return p1.x - p2.x;
			}
		
		});
		
		for(Point p: arr) {
			sb.append(p.x+" "+p.y+"\n");
		}
		
		System.out.print(sb);
		
	}
	
	public static class Point{
		int x;
		int y;
		
		public Point(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	

}
