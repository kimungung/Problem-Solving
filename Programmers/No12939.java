import java.util.Arrays;

/*
Programmers 12939 최댓값과 최솟값

*/

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr=s.split(" "); //공백으로 split
        int[] arrInt=new int[arr.length];

        for(int i=0; i<arr.length; i++){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(arrInt);      
        answer =(arrInt[0]+" "+arrInt[arrInt.length-1]);
        
        return answer;
    }
}
