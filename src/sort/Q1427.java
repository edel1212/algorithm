package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Q1427 {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))){
            String N = br.readLine();

            String result = Arrays.stream(N.split(""))
                    .map(Integer::parseInt)
                    .sorted(Comparator.reverseOrder())
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            bw.write(result);
            bw.flush();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

