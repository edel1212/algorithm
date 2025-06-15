package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호_R4 {

    public static void main(String[] args) {

    }

    boolean solution(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for(Character c : s.toCharArray()){
            if(c =='(' ){
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            } // if - else
        } // for

        return true;
    }


}
