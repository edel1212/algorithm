package programmers.hash;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 전화번호_목록_R3 {
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
        new 전화번호_목록_R3().solution(phone_book);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Map<String, Long> map = Arrays.stream(phone_book)
                .collect(Collectors.groupingBy(n->n, Collectors.counting()));


        for(int i = 0 ; i < phone_book.length ; i ++){

            for(int j = 1 ; j < phone_book[i].length(); j++){
                if(map.containsKey( phone_book[i].substring(0, j) ) ) return false;
            } // for

        } // for

        return answer;
    }
}
