import java.util.*;

/*
Programmers 42586 기능개발

*/

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> completeDay=new LinkedList<>();
        ArrayList<Integer> answerArr= new ArrayList<>();
        
        //완성 시일을 먼저 구한다.
        for(int i=0; i<progresses.length; i++){
            completeDay.add((100-progresses[i])/speeds[i]+(((100-progresses[i])%speeds[i] ==0) ? 0:1));
        }
        
        int top=completeDay.poll();
        int n=1;
       
        while(completeDay.peek() != null){
            if(completeDay.peek() <= top){
                n++;
                completeDay.poll();
               
            }else{
                answerArr.add(n);
                n=1;
                top=completeDay.poll();
            }
        }
        answerArr.add(n);
        
        answer = new int[answerArr.size()];
        
        for(int i=0; i<answerArr.size(); i++){
            answer[i]= answerArr.get(i);
        }
  
        return answer;
    }
}
