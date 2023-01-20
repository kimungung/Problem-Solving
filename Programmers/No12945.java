import java.util.*;

/*
Programmers 12945 피보나치 수

*/

//재귀는 시간초과
class Solution {
    public int solution(int n) {
        int answer = 0;
        int arrS=0;
        ArrayList<Integer> arr=new ArrayList<>();
        
        arr.add(0); 
        arr.add(1);
        arrS = arr.size();
        
        while(n>=arrS){
            arr.add(arr.get(arrS-1)%1234567+arr.get(arrS-2)%1234567);
            arrS++;
        }
  
        return arr.get(arrS-1)%1234567;
    }
}
