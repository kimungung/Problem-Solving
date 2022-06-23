import java.io.*;
import java.util.Deque;
import java.util.LinkedList;


/*
BOJ 18258번 큐2
deque

StringBuilder로 실행 시간을 줄이는 것이 좋다.

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			
			qOp(br.readLine().split(" "), dq, sb);
		}
		
		System.out.print(sb);

	}
	
	
	static void qOp(String[] str, Deque<Integer> dq, StringBuilder sb) {
		
		switch(str[0]) {
		
		case "push":
			dq.add(Integer.parseInt(str[1]));
			break;
		case "pop":
			if(dq.isEmpty()) sb.append("-1\n");
			else sb.append(dq.poll()+"\n");
			break;
		case "size": sb.append(dq.size()+"\n");
			break;
		case "empty":
			if(dq.isEmpty())  sb.append("1\n");
			else  sb.append("0\n");
			break;
		case "front":
			if(dq.isEmpty()) sb.append("-1\n");
			else  sb.append(dq.getFirst()+"\n");
			break;
		case "back":
			if(dq.isEmpty()) sb.append("-1\n");
			else sb.append(dq.getLast()+"\n");
			break;
		default: System.out.println("Check input!");
		
		}
		
	}

}
