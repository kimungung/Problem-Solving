/*
Programmers 12949 행렬의 곱셈

*/


class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int arr1L=arr1.length;
        int arr2L=arr2.length;
        int[][] answer = new int[arr1L][arr2[0].length];
        
        //평범한 행렬의 곱셈식
        for(int i=0; i<arr1L; i++){
            for(int j=0; j<arr2[0].length; j++){
                for(int k=0; k<arr2L; k++){
                    answer[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}
