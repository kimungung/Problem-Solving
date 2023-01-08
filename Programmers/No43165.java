/*
Programmers 43165 타겟 넘버
DFS/BFS


*/

class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    //-인 경우와 +인 경우를 각각 나눠서 계산
    public void dfs(int[] numbers, int i, int sum, int target){
        
        if(i == numbers.length){
            
            if(target == sum) answer++;    
            
        }else{  
            
            dfs(numbers, i+1, sum-numbers[i],target);
            dfs(numbers, i+1, sum+numbers[i],target); 
            
        }

    }
    
}
