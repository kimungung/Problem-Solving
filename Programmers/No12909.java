import java.util.*;

/*
Programmers 12909 올바른 괄호


*/

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> checkS=new Stack<>();
        
        if(s.charAt(0) == ')') return false;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) =='(') checkS.push('(');
            else if(!checkS.empty()) checkS.pop();
            else return false;
        }
   
        if(!checkS.empty()) answer=false;

        return answer;
    }
}
