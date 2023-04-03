import java.util.*;

/*
Programmers 131701 연속 부분 수열 합의 개수
HastSet 이용

*/

class Solution {
    public int solution(int[] elements) {
        int leng = elements.length;
        HashSet<Integer> h1 = new HashSet<>();
        
        
        for(int i=0; i<leng ; i++){
            int num = elements[i];
            
            h1.add(num);
            
            for(int j=i+1; j<leng+i; j++){
                
                num += elements[j%leng];
                h1.add(num);
                
            }
               
        }
        
        
        return h1.size();
    }
}
