import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*

15829번 Hashing
문자열, 큰 수 다루기(BigInteger), Hashing

*/

public class Main {
	
	static final BigInteger MOD =new BigInteger("1234567891");

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		BigInteger answer = new BigInteger("0");
		
		for(int i=0; i<n; i++) {
			int c = str.charAt(i)-96;
			BigInteger r = new BigInteger("31");
			
			r = r.pow(i);
			r = r.multiply(new BigInteger(Integer.toString(c)));
			r = r.mod(MOD);

			answer = answer.add(r);
			
		}
		
		answer = answer.mod(MOD);
		
		System.out.print(answer);
		

	}
	

}
