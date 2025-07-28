package programmers.brute_force.revenage;

import java.util.ArrayList;
import java.util.List;

public class 모음사전_R4 {
    public static void main(String[] args) {
        new 모음사전_R4().solution("A");
    }
    List<String> arr = new ArrayList<>();
    String[] words;
    public int solution(String word) {
        words = new String[]{"A", "E", "I", "O", "U"};
        dfs("",0);
        return arr.indexOf(word);
    }

    // 배열을 통해 모든 경우의 조합을 만드는 방법

   public void dfs(String add , int depth){
        if(5 < depth) return;
        arr.add(add);
       for(String chr : words){
           dfs(add + chr, depth+1);
       } // for

   }
}
