package programmers.hash.revenge;

import java.util.Arrays;

public class 전화번호_목록_R4 {

    public static void main(String[] args) {
        new 전화번호_목록_R4().solution(new String[]{"119", "97674223", "1195524421"});
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length ; i++){
            if( i + 1 >= phone_book.length ) return true;
            if(phone_book[i + 1].startsWith(phone_book[i])) return false;
        } // for
        return true;
    }
}
