package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호_R5 {
    boolean solution(String s) {

        Deque<String> stack = new ArrayDeque<>();

        for(Character c : s.toCharArray()){
            if(stack.isEmpty() && c == ')') return false;
            if( c == '('){
                stack.push(String.valueOf(c));
            } else {
                stack.pop();
            } //
        } // for

        return stack.isEmpty();
    }
}
