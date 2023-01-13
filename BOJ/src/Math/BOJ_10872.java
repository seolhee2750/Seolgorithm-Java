package Math;

/*
 * BOJ #10872 팩토리얼
 * https://www.acmicpc.net/problem/10872
 * 재귀
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_10872 {

    static int n, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        sum = factorial(n);
        System.out.println(sum);
    }

    public static int factorial(int n) {
        if(n <= 1) return 1;
        return n * factorial(n - 1);
    }
}