/*
Programmers 230816 피자 나눠 먹기(3)
기초 문제

*/

class Solution {
    public int solution(int slice, int n) {
        int answer = (int)Math.ceil(n/(float)slice);

        return answer;
    }
}
