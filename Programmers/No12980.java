/*
Programmers 12980 점프와 순간 이동

*/

public class Solution {
    public int solution(int n) {
        int ans = 1;
        
        while(n > 1){
            
            if(n%2 != 0){
                ans++;
                n -= 1;
            }
            
            n /= 2;
            
        }

        return ans;
    }
    
    
}
