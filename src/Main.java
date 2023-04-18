import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
      Double aa = 3.2844827586206895;

        System.out.println(
                (double)((int) (aa * 1_000_000))/1_000_000
        );
    }
}

