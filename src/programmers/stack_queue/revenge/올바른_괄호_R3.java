package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호_R3 {
    public static void main(String[] args){
        String s = "(()(";
        new 올바른_괄호_R3().solution(s);
    }

    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if( c == '(' ){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return  false;
                stack.pop();
            } // else
        } // for

        return stack.isEmpty();
    }
}
