/*
Programmers 120850 문자열 정렬하기(1)
문자열 | 정렬
replaceAll로 분류하거나, 람다식을 쓰는 쪽이 더 깔끔하다. 후자는 연산 속도를 고려할 필요가 있다.

*/

class Solution {
    public int[] solution(String my_string) {
        int[] answer;
        int[] number = new int[10];
        int count = 0;
        
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            
            if(Character.isDigit(c)){
                count++;
                number[c-'0']++;
            }
            
        }
        

        int i = 0;
        answer = new int[count];           

        for(int j=0; j<10; j++){
            while(number[j]-- > 0 && i < count){
                answer[i++] = j;
            }
        }   
      
        return answer;
    }
}
