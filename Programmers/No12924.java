/*
Programmers 12924 숫자의 표현

*/

class Solution {
    public int solution(int n) {
        int answer = 1;
        int sum =0;
        
        if(n ==1 || n ==2) return answer;
        
        for(int i=1; i< n/2+1; i++){
            sum = 0;
            for(int j=i; j<n; j++){
                sum += j;
                if(sum > n) break;
                else if(sum == n){
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
