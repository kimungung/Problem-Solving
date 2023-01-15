/*
Programmers 42747 H-Index

*/


class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int higer;
     
        for(int i=1; i<citations.length+1; i++){
            higer = 0;
            for(int j=0; j<citations.length; j++){
                if(citations[j] >= i) higer++;
            }
            if(citations.length - higer <= i && higer >= i){
                if(answer < i) answer = i;
            }   
        }
        
        return answer;
    }
}
