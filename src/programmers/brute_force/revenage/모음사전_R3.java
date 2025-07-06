package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 모음사전_R3 {
    List<String> result = new ArrayList<>();
    String[] words = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfs("",0);
        return  result.indexOf(word);
    }

    public void dfs(String add, int depth){
        if( 5 < depth ) return;
        result.add(add);
        for(String chr : words){
            dfs(add + chr, depth+1);
        } // for
    }

}
