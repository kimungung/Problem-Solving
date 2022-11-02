/*
Programmers 120848 팩토리얼

*/

class Solution {
    public int solution(int n) {
        int answer = 1;
        
        for(int i=2; answer < n; i++){
            
            answer *= i;
            
            if(answer > n){
                return (i-1);
            }else if(answer == n){
                return i;
            }
                
        }
        
        return 1;
    }
}
