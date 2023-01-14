import java.util.*;

/*
Programmers 76502 괄호 회전하기

*/

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder stb = new StringBuilder(s);
        
        if(testCorr(stb.toString())) answer++;

        for(int i=1; i<s.length(); i++){
            //s를 회전시킨다.
            stb.append(stb.substring(0,1));
            stb.delete(0,1);
            if(testCorr(stb.toString())) answer++;
        }
        
        return answer;
    }
    

    public boolean testCorr(String str){
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            if(st.empty()){
                st.push(str.charAt(i));
            }else{
                if(str.charAt(i) == '}'){
                    if(st.peek() == '{') st.pop();
                    else st.push('}');
                }else if(str.charAt(i) == ')'){
                    if(st.peek() == '(') st.pop();
                    else st.push(')');
                }else if(str.charAt(i) == ']'){
                    if(st.peek() == '[') st.pop();
                    else st.push(']');
                }else{
                    st.push(str.charAt(i));
                }
            }
        }
        
        if(st.empty()) return true;
        else return false;

    }
}
