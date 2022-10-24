/*
Programmers 120838 모스부호 (1)

*/

class Solution {
    public String solution(String letter) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder answer = new StringBuilder();
        String[] arr = letter.split(" ");
        
        for(int i=0; i<arr.length; i++){
            
            for(int j=0; j<morse.length; j++){
                
                if(morse[j].equals(arr[i])){
                    answer.append((char)('a'+j));
                    break;
                }
                
            }
            
            
        }
        
        
        return answer.toString();
    }
}
