import java.util.*;

/*
Programmers 42860 조이스틱
탐욕법(Greedy)

*/

class Solution {
    public int solution(String name) {
        int answer = 0;
        int[] count = new int[name.length()];
        int minCursor = name.length()-1;
        int cursorCount = 0;

        //모든 알파벳을 만드는 최솟값을 구한다.
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i) == 'A'){
                count[i] = 0; continue;
            }
            if((name.charAt(i) - 'A') < ('Z' -name.charAt(i)+1)){
                count[i] = name.charAt(i) - 'A';
                answer += count[i];
            }else{
                count[i] = 'Z' -name.charAt(i)+1;
                answer += count[i];
            }
        }

        for(int i = 1; i<name.length(); i++){
            //기본은 오른쪽으로 이동. A인지 먼저 체크한다.
            if(count[i] != 0){
                cursorCount++;
            }else{
                //A일 경우!
                //(1)로 돌아간다.
                int aNum = 1;
                int j = i+1;
                int ifCursor = cursorCount;
                while(j < name.length() && count[j] == 0){
                    aNum++;
                    j++; 
                }
                if( i == 1) {
                    ifCursor =name.length()-aNum-1;
                }else{
                    ifCursor =name.length()-aNum;
                }
                
                minCursor = Math.min(minCursor,ifCursor);
                
                //(2)그냥 진행한다.
                //이 뒤로 A뿐이라면!
                if(j == name.length()){
                    minCursor = Math.min(minCursor,cursorCount);
                    break;
                }else{
                    cursorCount++;
                }
            }   
        }

        answer += minCursor;
        
        return answer;
    }
}
