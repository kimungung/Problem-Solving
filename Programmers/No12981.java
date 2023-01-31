import java.util.*;

/*
Programmers 12981 영어 끝말잇기

*/

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        char lastChar = words[0].charAt(words[0].length()-1);
        LinkedList<String> arr = new LinkedList<>();
        
        arr.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            char c = words[i].charAt(0);
            
            if(lastChar != c){
                
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;

            }else{
                
                if(arr.contains(words[i])){
                    
                    answer[0] = i%n+1;
                    answer[1] = i/n+1;
                    break;
                }
                
            }
            
            arr.add(words[i]);
            lastChar = words[i].charAt(words[i].length()-1);
            
        }


        return answer;
        
    }
}
