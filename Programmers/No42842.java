/*
Programmers 42842 카펫

*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; //가로, 세로 순서
        int maxLength = brown/2;
        
        //경우의 수를 계산해봄... 2x가로+2x(세로-2)=brown = 2x(가로+세로-2)
        //(가로-2)x(세로-2)=yellow
        for(int i=3; i<maxLength; i++){
         for(int j=3; j<maxLength; j++){
             if(2*(i+j-2) == brown && (i-2)*(j-2)==yellow){
                 if(i>=j){
                    answer[0]=i;
                    answer[1]=j;
                    return answer;
                 }else{
                    answer[0]=j;
                    answer[1]=i;
                    return answer;
                 }
             }
             
         }   
        }
        return answer;
    }
}
