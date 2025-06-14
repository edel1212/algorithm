package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 전화번호_목록_R3 {

    public boolean solution(String[] phone_book) {

        Map<String, Long> map = Arrays.stream(phone_book).collect(Collectors.groupingBy(k->k, Collectors.counting()));

        for( int i = 0 ; i < phone_book.length; i++ ){
            for(int j = 0 ; j < phone_book[i].length() ; j++){
                String tmp = phone_book[i].substring(0,j);
                if(map.containsKey(tmp)) return true;
            } //for

        } // for

        return false;
    }

}
