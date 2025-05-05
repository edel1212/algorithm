package programmers.stack_queue.revenge;

import java.util.*;

public class 같은_숫자는_싫어_R {
    // goal : 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
    //        제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다.
    // condition : 배열 arr의 크기 : 1,000,000 이하의 자연수
    //             배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
    public static void main(String[] args){
        int[] arr = { 1,1,3,3,0,1,1 };
        new 같은_숫자는_싫어_R().solution2(arr);
    }

    public int[] solution(int[] arr){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]);

        for(int i = 1 ; i < arr.length ; i++){
            if( stack.peek() != arr[i] ) stack.push(arr[i]);
        } // for

        int[] answer = new int[stack.size()];
        int size = stack.size() - 1;
        while(!stack.isEmpty()){
            answer[size] = stack.pop();
            size--;
        } // loop

        return answer;
    }

    public int[] solution2(int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i = 1 ; i < arr.length ; i++){
            if( list.get( list.size()  - 1) != arr[i] ) list.add(arr[i]);
        } // for

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
