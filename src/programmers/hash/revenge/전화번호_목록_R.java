package programmers.hash.revenge;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 전화번호_목록_R {
    // 목적 : 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return
    public static void main(String[] args){
        전화번호_목록_R obj = new 전화번호_목록_R();
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(obj.solution2(phone_book));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i = 0 ; i < phone_book.length-1 ; i++){
            if( phone_book[i+1].startsWith(phone_book[i]) ) return false;
        }

        return answer;
    }

    public boolean solution2(String[] phone_book){

        Map<String, Integer> map = Arrays.asList(phone_book).stream()
                .collect(Collectors.toMap(i -> i, o -> 1));
        for(String key : map.keySet()){
            for( int i = 1; i <  key.length() ; i ++ ){
                if( map.containsKey( key.substring(0, i) )  ) return false;
            }//
        } // for

        return true;
    }
}
