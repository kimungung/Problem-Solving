/*
Programmers 42883 큰 수 만들기
Greedy


*/


class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder(number);
        int maxNum = sb.charAt(0) - '0';
        int checkNum = 0;
        
        while( k != 0 && k+checkNum < sb.length()){
            maxNum = sb.charAt(checkNum) - '0'; 
            for(int i=checkNum+1; i<=k+checkNum; i++){
                if(maxNum == 9) break;
                if(maxNum < sb.charAt(i)-'0'){
                    maxNum = sb.charAt(i)-'0';
                    sb.delete(checkNum,i);
                    k -= (i-checkNum);
                    i=checkNum;
                }
            }        
            checkNum++;
        }

        if(k != 0){
            sb.delete(sb.length()-k,sb.length());
        }
    
        return sb.toString();
    }
}
