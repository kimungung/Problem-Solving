/*
Programmers 42576 완주하지 못한 선수
해시

*/

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int i;
        Arrays.sort(completion);
        Arrays.sort(participant);
        
        for(i=0;i<completion.length;i++){
            
            if(!participant[i].equals(completion[i]))
                return participant[i];
            
        }
            
        return participant[i];
    }
}
