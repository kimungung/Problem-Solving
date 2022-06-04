import java.io.*;

/*

BOJ 1003번 피보나치 함수
DP

*/

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		int[] count0 = new int[41];
		int[] count1 = new int[41];
		int max =1;

		count0[0] = 1; count0[1] = 0;
		count1[0] = 0; count1[1] = 1;
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(max < num) {
				
				for(int j = max+1; j<=num; j++) {
					count0[j] = count0[j-1]+count0[j-2];
					count1[j] = count1[j-1]+count1[j-2];
					
				}
				max = num;
			}

			sb.append(count0[num]+" "+count1[num]+"\n");
			
		}
		
		bw.write(sb.toString());
		bw.close();		
	}

}
