import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 1991번 트리 순회
트리

*/


public class Main {

	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Node[] arr = new Node[n];
		sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			arr[i] = new Node((char)(65+i));
		}
		

		for(int i=0; i<n; i++) {
			char[] charArr = br.readLine().toCharArray();
			int num = (charArr[0]-'0')-17;

			if(charArr[2] != '.') {
				arr[num].setLeft(arr[(charArr[2]-'0')-17]);
			}
			
			if(charArr[4] != '.') {
				arr[num].setRight(arr[(charArr[4]-'0')-17]);
			}

		}
		
		
		preOrder(arr[0]);
		sb.append('\n');
		inOrder(arr[0]);
		sb.append('\n');
		postOrder(arr[0]);

		
		System.out.print(sb);
		
	}
	
	
	
	static void inOrder(Node now) {
		
		
		if(now.getLeft() != null) {
			inOrder(now.getLeft());
		}

		sb.append(now.getRoot());
		
		if(now.getRight() != null) {
			inOrder(now.getRight());
		}

	}
	
	
	static void preOrder(Node now) {
		
		
		sb.append(now.getRoot());
		
		if(now.getLeft() != null) {
			preOrder(now.getLeft());
		}
		if(now.getRight() != null) {
			preOrder(now.getRight());
		}
		
	}
	
	
	static void postOrder(Node now) {
		
		
		if(now.getLeft() != null) {
			postOrder(now.getLeft());
		}
	
		if(now.getRight() != null) {
			postOrder(now.getRight());
		}

		sb.append(now.getRoot());
		
	}


}


class Node{
	
	char root;
	Node right = null;
	Node left = null;
	
	
	Node(char root){
		this.root = root;
	}
	
	
	Node(char root, Node right, Node left){
		this.root = root;
		this.left = left;
		this.right = right;
	}
	
	
	
	public char getRoot() {
		return root;
	}
	public void setRoot(char root) {
		this.root = root;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}

}
