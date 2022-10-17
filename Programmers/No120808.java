/*
Programmers 120808 분수의 덧셈
GCD의 기초

*/

class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = new int[2];
    
        answer[0] = denum1*num2 + denum2*num1;
        answer[1] = num1*num2;
    
        if(answer[0]%answer[1] == 0){
            
            answer[0] /= answer[1];
            answer[1] = 1;
            
        }else if(answer[1]%answer[0] == 0){
            
            answer[1] /= answer[0];
            answer[0] = 1;
            
        }else{
            int max = answer[0]>answer[1] ? answer[0] : answer[1];
            
            for(int i=2; i<=Math.sqrt(max); i++){
                
                if(answer[1]%i == 0 && answer[0]%i == 0){
                    answer[1] /= i;
                    answer[0] /= i;
                }
                
            }

        }

        
        return answer;
    }
}
