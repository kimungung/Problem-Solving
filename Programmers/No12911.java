/*
Programmers 12911 다음 큰 숫자

*/

class Solution {
    public int solution(int n) {
        int answer = 0;
        String nToStr = Integer.toBinaryString(n);
        String nextStr= Integer.toBinaryString(n+1);
        int countOrig1 = countOne(nToStr);
        int count1 = countOne(nextStr);
        int i=1;
        
        while(countOrig1  != count1){
            nextStr = Integer.toBinaryString(n+i);
            i++;
            count1 = countOne(nextStr);
        }
        
        answer = Integer.parseInt(nextStr,2);
        return answer;
    }
    
    int countOne(String str){
        int answer=0;
        char[] arr=str.toCharArray();
        
        for(int i=0; i<arr.length; i++){
            if( arr[i] == '1') answer++;
        }

        return answer;
    }
}
