package do_it.two_dimensional_array;

import java.util.ArrayList;
import java.util.List;

public class ex01 {
    public static void main(String[] args) {
        // ✅2차원 배열
        List<Edge>[] list = new ArrayList[10];
        // list[0].get(0);
        // 👉 2중 리스트로 만들 수 도 있음
        List<List<Edge>> list2 = new ArrayList<>();

    }

    public static class Edge{
        int endNode;
        int value;
    }
}
