package Strings;

/**
 * BOJ #12919 A와 B 2
 * https://www.acmicpc.net/problem/12919
 * 문자열
 */

import java.io.*;

public class BOJ_12919 {

    static String S, T;
    static int sLen;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        S = in.readLine();
        T = in.readLine();
        sLen = S.length();

        System.out.println(game(T));
    }

    static int game(String str) {
        if(str.length() == sLen) {
            if(str.equals(S)) {
                return 1;
            } else {
                return 0;
            }
        }

        if(str.charAt(str.length()-1) == 'A') {
            if(game(str.substring(0, str.length()-1)) == 1) {
                return 1;
            }
        }

        if(str.charAt(0) == 'B') {
            StringBuilder reverse = new StringBuilder();
            reverse.append(str.substring(1, str.length()));
            if(game(reverse.reverse().toString()) == 1) {
                return 1;
            }
        }

        return 0;
    }
}