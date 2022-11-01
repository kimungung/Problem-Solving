/*
Programmers 120842 2차원으로 만들기
나머지를 이용하면 for문을 더 단순하게 만들 수 있다.

*/

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        
        for(int i=0; i<num_list.length; ){
            int[] arr = new int[n];
            
            for(int j=0; j<n; j++)
                arr[j] = num_list[i++];
            
            answer[i/n-1] = arr.clone();
        }
        
        return answer;
    }
}
