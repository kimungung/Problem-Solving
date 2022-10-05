
/*
Programmers 120956 옹알이
정규표현식을 이용한 풀이가 더 효율적이다.
일정한 규칙이 존재하므로!

*/

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;


        for(int i=0; i<babbling.length; i++){
            String str = babbling[i];

            if(str.length() < 4){

                if(checkBubbling(str))
                    answer++;

            }else{

                boolean check = true;
                char preChar = 'z';

                while(check == true){

                    if(str.length() == 0){
                        answer++; break;
                    }

                    char c = str.charAt(0);

                    switch(c){

                        case 'a':
                            if(preChar != 'a' && str.length() >= 3 && checkBubbling(str.substring(0,3)))
                                str = str.substring(3);
                            else 
                                check = false;
                            preChar = 'a'; break;
                        case 'w':
                            if(preChar != 'w' && str.length() >= 3 && checkBubbling(str.substring(0,3)))
                                str = str.substring(3);
                            else 
                                check = false;
                            preChar = 'w'; break;
                        case 'y':
                            if(preChar != 'y' && str.length() >= 2 && checkBubbling(str.substring(0,2)))
                                str = str.substring(2);
                            else 
                                check = false;
                            preChar = 'y'; break;
                        case 'm':
                            if(preChar != 'm' && str.length() >= 2 && checkBubbling(str.substring(0,2)))
                                str = str.substring(2);
                            else 
                                check = false;
                             preChar = 'm'; break;

                        default: check = false; break; 

                    }

                }


            }


        }

        return answer;
    }


    public boolean checkBubbling(String str){
        String[] right = {"aya", "ye", "woo", "ma"};


        for(int j=0; j<4; j++){

            if(right[j].equals(str)){
                return true;
            }

         }

        return false;
    }


}
