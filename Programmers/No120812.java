/*
Programmers 120812 최빈값 구하기
기초 문제 중 하나

*/

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] arr = new int[2000];
        boolean check = false;
        
        for(int i=0; i<array.length; i++){
            arr[999+array[i]]++;
        }
        
        for(int i=1; i<2000; i++){
            
            if(arr[answer] < arr[i]){
                answer = i;
                check = false;
            }else if(arr[answer] == arr[i]){
                check = true;
            }
    
        }
        
        if(check)
            return -1;
        
        return answer-999;
    }
}
