import java.io.*;

/*

BOJ 1427번 소트인사이트
2751번과 비슷하게 int[]를 만들어 count하는 쪽이 더 효율적이다.

*/

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int length = arr.length;
		int check = 0;

		for (int i = 9; i >= 0; i--) {

			if (check == length - 1)
				break;

			for (int j = check; j < length; j++) {
				if(arr[j]-'0' == i) {
					arr[j] = arr[check];
					arr[check] = Character.forDigit(i,10);
					check++;
				}
			}

		}
		
		for(char v: arr)
		System.out.print(v);

	}

}
