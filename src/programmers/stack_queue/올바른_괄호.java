package programmers.stack_queue;

import java.util.Stack;

public class 올바른_괄호 {
    // 목적 : '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻
    //       - ()()" 또는 "(())()" 는 올바른 괄호
    //       - ")()(" 또는 "(()(" 는 올바르지 않은 괄호
    // 조건 : - 문자열 s의 길이 : 100,000 이하의 자연수
    //       - 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
    public static void main(String[] args){
        올바른_괄호 obj = new 올바른_괄호();
        //String s = "(())()";
        String s = "(()))(()";
        System.out.println(obj.solution(s));
    }

    // 솔루션 : 문자열을 char로 변환
    //       - ")" 로 시작할 경우 무조건 false 반환
    //       - queue에 값을 넣은 후 () 경우 clear
    //       - 베열이 전부 끝났을 경우에는 true 반환
    public boolean solution(String s){

        char firstChar = s.charAt(0);
        if(firstChar == ')') return false;

        Stack<String> stack = new Stack<>();
        stack.add( Character.toString( firstChar ) );
        for(int i = 1 ; i < s.length() ; i++){
            String nextChar = Character.toString( s.charAt(i) );
            if(stack.size() == 0){
                if(")".equals(nextChar)) return false;
                stack.add(nextChar);
            } else if( stack.peek().equals( nextChar ) ){
                stack.add(nextChar);
            }else{
                stack.pop();
            } // if - else
        }

        if(stack.size() > 0) return false;

        return true;
    }

    public boolean solution2(String s){
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else {
                count--;
                if (count < 0) return false; // ')'가 먼저 나옴
            }
        }
        return count == 0;
    }
}
