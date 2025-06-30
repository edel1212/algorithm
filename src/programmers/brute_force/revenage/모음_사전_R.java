package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 모음_사전_R {
    List<String> dictionary = new ArrayList<>();
    String[] vowels = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        new 모음_사전_R().solution("I");
    }

    public int solution(String word) {
        dfs("", 0);
        return dictionary.indexOf(word);
    }

    public void dfs(String current, int depth){
        if(depth > 5) return;
        dictionary.add(current);
        for(String chr : vowels){
            dfs( current + chr, depth +1 );
        } // for
    }

}
