/*
Programmers 12953 N개의 최소공배수

*/


class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        answer = arr[0]*arr[1]/gcd(arr[0],arr[1]);
        
        //유클리드 호제법 
        for(int i=2; i<arr.length; i++){
            answer = answer*arr[i]/gcd(arr[i],answer);
        }

        return answer;
    }
    
    public int gcd(int a, int b){
        int r;
        int temp=0;
        
        if(a<b){
            temp = a;
            a = b;
            b = temp;
        }
        
        r = a%b;
        
        while(r>0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
        
    }

    
}
