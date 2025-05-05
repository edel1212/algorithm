package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호_R {
    public static void main(String[] args){

    }

    public boolean  solution(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                if (stack.isEmpty()) return false; // 짝이 안 맞음
                stack.pop();
            }
        }

        return stack.isEmpty(); // 스택이 비어야 모든 괄호가 짝을 이룸
    }

    public boolean solution2(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            if( c == '(' ){
                stack.push(c);
            } else {
                if( stack.isEmpty() ) return  false;
                stack.pop();
            } // if - else
        } // for

        return stack.isEmpty();
    }
}
