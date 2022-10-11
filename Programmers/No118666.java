/*
Programmers 118666 성격 유형 검사하기
미리 어느 정도 배열로 규칙성을 구현한 뒤, 
HashMap을 이용하는 풀이가 더 깔끔하고 간단하다.

*/

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int[] scores = new int[8];
        
        for(int i=0; i<survey.length; i++){
            int num1 = Type.valueOf(survey[i].substring(0,1)).ordinal();
            int num2 = Type.valueOf(survey[i].substring(1,2)).ordinal();

            switch(choices[i]){
                    
                case 1: scores[num1] += 3; break;
                case 2: scores[num1] += 2; break;
                case 3: scores[num1]++; break;
                case 5: scores[num2]++; break;
                case 6: scores[num2] += 2; break;
                case 7: scores[num2] += 3; break;
                default: break;
    
            }
            
        }
        
        for(int i=0; i<8; i += 2){
            String a = Type.values()[i].name();
            String b = Type.values()[i+1].name();
            
            if(scores[i] > scores[i+1]){
                answer.append(a);
            }else if(scores[i+1] > scores[i]){
                answer.append(b);
            }else{
                answer.append(a.compareTo(b) < 0 ? a : b);
            }
            
        }
        
        
        return answer.toString();
    }
}

        
enum Type{
    R, T, C, F, J, M, A, N      
}
