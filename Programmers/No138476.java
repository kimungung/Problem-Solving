import java.util.*;

/*
Programmers 138476 귤 고르기

*/

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int arrSize = k;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            
            if(hm.containsKey(tangerine[i])){
                hm.put(tangerine[i], hm.get(tangerine[i])+1);
            }else{
                hm.put(tangerine[i],1);
            }
            
            
        }
        
        List<Integer> valueSet = new ArrayList<>(hm.values());
        
        Collections.sort(valueSet);
        
        for(int i=valueSet.size()-1; i>=0; i--){

            arrSize -= valueSet.get(i);
            answer++;
            
            if(arrSize <= 0){
                break;
            }
            
        }
        
        
        return answer;
    }
}
