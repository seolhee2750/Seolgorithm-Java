package Math;

/**
 * BOJ #9656 돌 게임 2
 * https://www.acmicpc.net/problem/9656
 * 수학
 */

import java.io.*;

public class BOJ_9656 {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());

        if(N % 2 == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
