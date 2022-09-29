
/*
Programmers SkillCheck 2번
문자열

*/


class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");
        int[] arr1 = new int[26]; //대문자를 할당할 arr
        int[] arr2 = new int[26]; //소문자를 할당할 arr
        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c >= 'A' && c <= 'Z'){
                arr1[c-'A']++;
            }else{
                arr2[c-'a']++;
            }
            
        }
        
        
        char c = 'z';
        
        for(int i=arr2.length-1; i>=0; i--){
           
            while(arr2[i]-- > 0){
                sb.append(c);
            }
            
            c--;    
        }
          
        
        c = 'Z';
         
        for(int i=arr1.length-1; i>=0; i--){
            
            while(arr1[i]-- > 0){
                sb.append(c);
            }
            
            c--;
            
        }
        
        answer = sb.toString();
              
        return answer;
    }
}
