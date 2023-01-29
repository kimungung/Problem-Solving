/*
Programmers 12951 JadenCase 문자열 만들기

*/

class Solution {
    public String solution(String s) {
        String testStr =s.toLowerCase(); //소문자로 할당
        String answer ="";
        boolean reset=true;
        
        for(int i=0; i<s.length();i++){
            if(reset){
                if(testStr.charAt(i) !=' '){
                    answer += Character.toString(Character.toUpperCase(testStr.charAt(i)));
                    reset=false;
                    continue;
                }
            }else{
                if(testStr.charAt(i) ==' ') {
                    reset=true;
                }
            }
            answer += Character.toString(testStr.charAt(i));
        }
        
        return answer;
    }
}
