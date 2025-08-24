package do_it.multiple_sort;

import java.util.*;

public class ex01 {
    public static void main(String[] args) {

        /** Collections를 사용한 정렬 **/
        List<Integer> arr = new ArrayList<>();
        // 오름 차순
        Collections.sort(arr);
        // 내림 차순
        Collections.sort(arr,Comparator.reverseOrder());

        ///////////////////////////////////////////////
        /** Collection 내장 함수를 사용한 정렬 **/
        List<Integer> arr2 = new ArrayList<>();
        // 기본 타입 리스트 - 👎 오버 플로우가 발생 할 수 있음
        arr2.sort(((o1, o2) -> o1 - o2));
        // 기본 타입 리스트 - 👍 안정적임
        arr2.sort(Integer::compare);
        arr2.sort((a,b) ->Integer.compare(a,b));
        // 내림 차순 정렬
        arr2.sort(Comparator.naturalOrder());
        // 오름차순 정렬
        arr2.sort(Comparator.reverseOrder());
        //  ✅ 객체 정렬에는 comparing을 사용해야함
        List<Person> list2 = new ArrayList<>();
        list2.sort(Comparator.comparing(a->a.age));
        // compareThan - 첫 번째 객체가 기준이 되어 두 번째와 비교
        // - 클래스 자체가 “난 이렇게 정렬할 수 있어”라고 정의한 것.
        arr2.sort((a,b)-> a.compareTo(b));


        ///////////////////////////////////////////////

        List<Person> list = new ArrayList<>();
        Person p = new Person("yoo",5);
        list.add(p);
        /** Comparable 사용 - Override 된 메서드 사용 **/
        Collections.sort(list);
        /** Comparator 사용 - 생성자 생성 후 주입 **/
        Collections.sort(list, new AageComparator());


    }

    /**
     * Comparable를 구현 한 정렬
     * <p>자기 자신에 정렬의 기준을 정해 놓음</p>
     */
    public static class Person implements Comparable<Person>{
        String name;
        int age;

        public Person(String name , int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString(){
            return name + ":::" + age;
        }

        @Override
        public int compareTo(Person o) {
            if( this.age == o.age ){
                return this.name.compareTo(o.name);
            }
            // 오름 차순 [ 뺀 결과 값이 음수면 앞으로 || 양수면 뒤로 ]
            return this.age - o.age;
        }
    }

    /**
     * Comparator를 구현 클래스
     * <p>해당 Class를 주입하여 정렬에 사용함</p>
     */
    public static class AageComparator implements Comparator<Person>{
        @Override
        public int compare(Person o1, Person o2) {
            if( o1.age == o2.age ){
                return o1.name.compareTo(o2.name);
            }
            // 오름 차순 [ 뺀 결과 값이 음수면 앞으로 || 양수면 뒤로 ]
            return o1.age - o2.age;
        }
    }
}
