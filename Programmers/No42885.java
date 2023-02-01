import java.util.Arrays;

/*
Programmers 42885 구명보트
탐욕법(Greedy)

*/

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int floor = 0;
        
        Arrays.sort(people);
        
        for(int i = people.length-1; i>=floor; i--){
      
            if(floor != i){
                
                if(people[i]+people[floor] <= limit){
                    floor++;
                    
                }
            }

            answer++; 
            
        }
        
        return answer;
    }
}
