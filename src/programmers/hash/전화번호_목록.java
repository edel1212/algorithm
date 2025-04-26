package programmers.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 전화번호_목록 {

    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        전화번호_목록 obj = new 전화번호_목록();
        // 목적 : 배열 내 번호가 "다른 번호의 접두어인 경우가 있는지 확인 접두어가 있을 경우" : false // 없없 경우 : ture
        // 전제 조건 : - 배열의 길이 1 이상 1,000,000 이하
        //          - 각 전화번호의 길이는 1 이상 20 이하입니다.
        //          - 같은 전화번호가 중복해서 들어있지 않습니다.
        System.out.println(obj.solution2(phoneBook));
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0 ; i < phone_book.length - 1 ; i++){
            if( phone_book[i + 1].startsWith(phone_book[i]) ) return false;
        } // loop
        return answer;
    }

    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        Map<String, Integer> map = new HashMap<>();
        // 전제 조건 중복이 없기에 1 사용
        for(String item : phone_book) map.put(item, 1);

        // 첫번째 loop에서 키 값 확인 각각의 String의 문자를 쪼개서
        for(int i = 0 ; i < phone_book.length ; i++){
            for(int j = 1; j < phone_book[i].length() ; j++){
                // ✅ substring(0,0은 불필요함 어차피 ""로 아무것도 안나옴)
                // "j < phone_book[i].length()" 인 이유는 자기 자신을 찾기 때문임 불필요
                // 어차피 map 내 containsKey를 사용해 검사하기에 모든 경우의 수를 확인 가능함
                if( map.containsKey(phone_book[i].substring(0,j))) return false;
            }// loop
        } // loop

        return answer;
    }
}



