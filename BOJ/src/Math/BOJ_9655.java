package Math;

import java.io.*;

public class BOJ_9655 {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        if(N % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
