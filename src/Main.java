import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
        System.out.println(Arrays.toString(arr.toArray()));
        System.out.println("----------------------------------------");
        arr.remove(1);
        System.out.println(Arrays.toString(arr.toArray()));
        System.out.println("----------------------------------------");
        arr.add(9,1);
        System.out.println(Arrays.toString(arr.toArray()));
        System.out.println("----------------------------------------");
    }
}