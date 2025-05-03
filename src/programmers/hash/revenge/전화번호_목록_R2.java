package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 전화번호_목록_R2 {
    // goal : 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
    //        어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
        new 전화번호_목록_R2().solution(phone_book);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for(int i = 0 ; i < phone_book.length -1 ; i ++){
            if(phone_book[i + 1].startsWith(phone_book[i])) return  false;
        }

        return answer;
    }

    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        Map<String, Long> map = Arrays.stream(phone_book)
                .collect(Collectors.groupingBy( s -> s, Collectors.counting()));

        for(int i = 0 ; i < phone_book.length ; i++){
            for(int j = 1 ;  j < phone_book[i].length() ; j++ ){
                if( map.containsKey( phone_book[i].substring(0, j) ) ) return false;
            } // if
        } // for

        return answer;
    }
}
