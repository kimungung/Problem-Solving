import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
BOJ 10769번 행복한지 슬픈지
문자열 | 파싱 | 정규표현식
단순 비교하거나, string.startsWith 함수를 이용하는게 조금 더 빠르다.

*/

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.concat(".");
		String[] arr1 = str.split(":-\\(");
		String[] arr2 = str.split(":-\\)");
		int length1 = arr1.length;
		int length2 = arr2.length;
		
		if(length1 > length2) {
			System.out.print("sad");
		}else if(length1 < length2) {
			System.out.print("happy");
		}else if(arr1[0].equals(str)) {
			System.out.print("none");
		}else {
			System.out.print("unsure");
		}

	}


}
