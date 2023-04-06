import java.util. *;

/*
Programmers 42577 전화번호 목록
효율성 테스트를 신경쓸 것.

*/

class Solution {
    public boolean solution(String[] phone_book) {
        
        //사전순 정렬
        Arrays.sort(phone_book);
        
         for(int i=0; i<phone_book.length-1; i++){
            String str1 = phone_book[i];
          
            for(int j=i+1; j<phone_book.length; j++){                
                String str2 = phone_book[j];
                
                if(str2.length() > str1.length()){
                    String str3 = str2.substring(0,str1.length());
                
                    if(str1.equals(str3)){
                        return false;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
 
            }
                     
        }

        
        return true;
    }
}
