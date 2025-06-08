package programmers.brute_force.revenage;

public class 최소직사각형_R2 {
    public int solution(int[][] sizes) {
        int row = 0;
        int col = 0;

        for(int[] item : sizes){
            int maxRow = Math.max(item[0], item[1]);
            int minCol = Math.min(item[0], item[1]);

            row = Math.max(row, maxRow);
            col = Math.max(col, minCol);
        } // for

        return row * col;
    }
}
