/*
Programmers 131128 숫자 짝꿍

*/

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] arrX = new int[10];
        int[] arr = new int[10];
        
        for(int i=0; i<X.length(); i++){
            arrX[X.charAt(i)-'0']++;
        }
        
        for(int i=0; i<Y.length(); i++){
           int n = Y.charAt(i)-'0';
            
            if(arrX[n] != 0){
                arr[n]++;
                arrX[n]--;
            }
            
        }
        
        for(int i=9; i>=1; i--){
            
            while(arr[i]-- > 0){
                sb.append(i);
            }
            
        }
        
        if(sb.length() == 0){
            
            if(arr[0] != 0){
                sb.append(0);
            }else{
                sb.append(-1);
            }
            
        }else{
            while(arr[0]-- > 0){
                sb.append(0);
            }
        }
            
        
        return sb.toString();
    }
}
