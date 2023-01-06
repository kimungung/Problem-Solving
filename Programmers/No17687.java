/*
Programmers 17687 n진수 게임

*/

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String numStr="0";
        int num =1;
        
        //t개를 구해야하므로 해당값만큼 loop
        for(int i=0; i<t; i++){
            int count =p+i*m-1;
            while(count >= numStr.length()){
                numStr = strCal(n,num++,numStr);
            }
            answer += Character.toString(numStr.charAt(count));
        }
        
        return answer;
    }
    
    String strCal(int n, int num, String str){
        String ans ="";
        
        //11진법부터는 다르게 체크해야한다. 
        
        if(n<=10){
            while(num>0){
                ans = num%n +ans;
                num /= n;
            }
        }else{
            while(num>0){
                switch(num%n){
                    case 15: ans = "F"+ans; break;
                    case 14: ans = "E"+ans; break;
                    case 13: ans = "D"+ans; break;
                    case 12: ans = "C"+ans; break;
                    case 11: ans = "B"+ans; break;
                    case 10: ans = "A"+ans; break;
                    default: ans = num%n +ans; break;
                }
                
                num /= n;
            } 
        }

        return str+ans;
    }
    
}
