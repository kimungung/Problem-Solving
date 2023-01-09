import java.util.*;

/*
Programmers 42587 프린터
스택/큐

*/

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        int nowLocation = location;
        List<Integer> printList= new ArrayList<>();

        for(int i=0; i<priorities.length; i++) printList.add(priorities[i]);

        while(answer < priorities.length){
            for(int i=0; i<printList.size(); i++){
                if(checkV(printList,printList.get(0))){
                    printList.add(printList.get(0));
                    printList.remove(0);
                    if(nowLocation == 0){
                        nowLocation = printList.size()-1;
                    }else nowLocation--;
                    
                }else{ //현재가 최댓값!
                    printList.remove(0);                     
                    if(nowLocation == 0){
                        return answer;
                    }else nowLocation--;
                    break;
                }
                 
            }
           
            answer++;
        }
        
        //마지막 순서인 경우
        return answer;
    }
    
    boolean checkV(List<Integer> l, int v){
        
        for(int i=v+1; i<10; i++){
            if(l.contains(i)) return true;
        }
        return false;
    }
    
}
