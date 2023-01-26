/*
Programmers 70129 이진 변환 반복하기

*/

class Solution {
    public int[] solution(String s) {
        int[] answer;
        int sLength=s.length();
        int zeroNum=0;
        int changeNum=0;
        
        while(!s.equals("1")){
            s = s.replace("0","");
            zeroNum += (sLength - s.length());
            s = Integer.toBinaryString(s.length());
            changeNum++;
            sLength = s.length();
        }   
        answer = new int[]{changeNum,zeroNum};
        
        return answer;
    }
}
