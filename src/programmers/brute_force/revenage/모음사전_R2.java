package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 모음사전_R2 {
    List<String> dictionary = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        new 모음사전_R2().solution("A");
    }

    public int solution(String word) {
        dfs("",0);
        // 빈 문자열을 한번 저장하기에 가능함
        return dictionary.indexOf(word);
    }

    public void dfs(String world, int depth){
        if(depth > 5) return;
        dictionary.add(world);
        for( String chr : vowels ){
            dfs(world + chr , depth + 1);
        } // for
    }
}
