import java.util.*;

/*
Programmers 42862 체육복
Greedy

*/

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        ArrayList<Integer> reserveArr=new ArrayList<Integer>();
        
        Arrays.sort(lost);
        
        for(int i: reserve){
            reserveArr.add(i);
        }
                
        for(int i=0; i<lost.length;i++){
            if(reserveArr.contains(lost[i])){
                //자신의 여벌 체육복 사용 
                reserveArr.remove(reserveArr.indexOf(lost[i]));
                answer++;
                lost[i]=-100;
            }
        }
        
          for(int i=0; i<lost.length;i++){
                if(reserveArr.contains(lost[i]-1)){
                    reserveArr.remove(reserveArr.indexOf(lost[i]-1));
                    answer++;
                }else if(reserveArr.contains(lost[i]+1)){
                    reserveArr.remove(reserveArr.indexOf(lost[i]+1));
                    answer++;
                }
          }

        return answer;
    }
}
