import java.util.*;

/*
Programmers 49993 스킬트리

*/

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Character> arr = new ArrayList<>();
        int checkSkill=0;
        
        for(int i=0; i<skill.length(); i++){
            arr.add(skill.charAt(i));
        }
        
        for(int i=0; i<skill_trees.length; i++){
            checkSkill = 0;
            //각 스킬 트리를 체크
            for(int j=0; j<skill_trees[i].length(); j++){
                if(arr.contains(skill_trees[i].charAt(j))){
                     if(arr.indexOf(skill_trees[i].charAt(j)) == checkSkill){
                         checkSkill++;
                     }else{
                         answer--; break;
                     }  
                }
            }
            answer++;
        }
        return answer;
    }
}
