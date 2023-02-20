/*
Programmers 87390 n^2 배열 자르기
규칙을 찾으면 쉽다.

*/

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        int count = 0;
         
        for(long i=left; i<=right; i++){
            
            answer[count++] = findNum((int)(i/n+1), (int)(i%n));
     
        }

        return answer;
    }
    
    
    int findNum(int i, int j){
        
        if(j < i){
            return i;
        }else{
            return j+1;    
        }
        
    }
    
}
