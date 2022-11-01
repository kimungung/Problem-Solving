import java.math.BigInteger;

/*
Programmers 120840 구슬을 나누는 경우의 수
큰 수 다루기

*/

class Solution {
    public int solution(int balls, int share) {
        
        if(balls == share)
            return 1;
        
        BigInteger n = fact(balls - share).multiply(fact(share));
        BigInteger answer = fact(balls).divide(n);
        
    
        return answer.intValue();
    }
    
    public BigInteger fact(int n){
        BigInteger ans = new BigInteger(Integer.toString(n));
        
        for(int i=2; i<n; i++)
            ans = ans.multiply(BigInteger.valueOf(i));
        
        return ans;
        
    }

}
