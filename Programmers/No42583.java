import java.util.*;

/*
Programmers 42583 다리를 지나는 트럭
Stack/Queue

*/

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> readyTruckQ = new LinkedList<>();
        Queue<Integer> bridgeQ = new LinkedList<>();
        int nowWeight = 0;
        
        for(int i=0; i<bridge_length; i++){
            bridgeQ.add(0);
        }
            
        for(int i: truck_weights){
            readyTruckQ.add(i);
        }
        
        //다리 위에 대기 중인 트럭을 올린다.
        //0을 poll하고, 트럭을 올린다. 이후 트럭을 올릴 때마다, 무게가 weight이하인지 체크한다.
        while(!readyTruckQ.isEmpty()){            
            //맨 앞을 내보낸다.
            if(bridgeQ.peek() != 0){
                nowWeight -= bridgeQ.peek();
            }
            bridgeQ.poll();
            
            if(nowWeight+readyTruckQ.peek() <= weight){
                nowWeight += readyTruckQ.peek();
                bridgeQ.add(readyTruckQ.poll());
            }else{
                bridgeQ.add(0);
            }

            time++;
        }
        
        //마지막 남은 트럭들을 다 내보내는 과정이 필요하다.
        while(!bridgeQ.isEmpty()){
            bridgeQ.poll();
            time++;
        }

        return time;
    }
}
