package programmers.stack_queue.revenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호_R2 {
    public static void main(String[] args){
        //String s = "(())()";
        String s = "(()(";
        System.out.println(new 올바른_괄호_R2().solution(s));
    }

    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {  // c == ')'
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();  // 짝이 되는 '(' 제거
            }
        }

        return stack.isEmpty();  // 스택이 비어야 올바른 괄호
    }

    boolean solution2(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){

            // '(' 일 경우만 올바른 경우기에 Push
            if( c == '(' ){
                stack.push(c);
            } else {
                // ')'가 들어올경우 잘못된 것이므로 첫번째가 )면 stack이 비워있어야함
                if( stack.isEmpty() ) return  false;
                stack.pop();
            } // if - else

        } // for

        return stack.isEmpty();
    }

    boolean solution3(String s){

        Deque<Character> stack = new ArrayDeque<>();


        for(Character c : s.toCharArray()){

            if(c == '('){
                stack.push(c);
            } else {

                if(stack.isEmpty()) return false;

                stack.pop();
            } //

        }// for

        return stack.isEmpty();
    }

}
