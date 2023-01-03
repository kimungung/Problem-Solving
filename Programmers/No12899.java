/*
Programmers 12899 124 나라의 숫자
3진법과 흡사하나 다른 부분이 존재한다

*/

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        //3진법과 흡사해 보이지만 다르다.
        while(n > 0){
            if(n%3 == 0){
                sb.append("4");
                n = n/3-1;
            }else{
                sb.append(n%3);
                n = n/3;
            }
        }
        sb.reverse();

        return sb.toString();
    }
}
