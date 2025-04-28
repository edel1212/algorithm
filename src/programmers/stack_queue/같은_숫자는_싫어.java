package programmers.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class 같은_숫자는_싫어 {
    // 목적 : 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거
    // 전제 조건 : - 배열 arr의 크기 : 1,000,000 이하의 자연수
    //          - 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
    public static void main(String[] args){
        int[] arr = {1,1,3,3,0,1,1};
        같은_숫자는_싫어 obj = new 같은_숫자는_싫어();
        System.out.println(obj.solution(arr));
    }

    // 배열을 순회하며 저장
    // 추가 시 이전 배열의 값 확인 다를 경우만 add
    public int[] solution(int []arr) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++){
            if(i == 0){
                list.add(arr[i]);
                continue;
            }

            if( list.get(list.size()-1) != arr[i] ) list.add(arr[i]);;
        }//for

        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
