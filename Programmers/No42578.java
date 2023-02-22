import java.util.*;
import java.util.Map.Entry;

/*
Programmers 42578 위장
해시

*/

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> m = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            
            if(m.get(clothes[i][1]) == null){
                m.put(clothes[i][1],1);
            }else{
                m.put(clothes[i][1], m.get(clothes[i][1])+1);
            }
            
        }
        
        for(Entry<String, Integer> e: m.entrySet()){
            answer *= (e.getValue()+1);
            
        }
        
        
        return answer-1;
    }
}
