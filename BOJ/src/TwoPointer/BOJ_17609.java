package TwoPointer;

/**
 * BOJ #17609 회문
 * 투포인터
 * https://www.acmicpc.net/problem/17609
 */

import java.io.*;

public class BOJ_17609 {

    static int T;
    static int check1;
    static int check2;

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(in.readLine());

        for(int t = 0; t < T; t++) {
            String str = in.readLine();
            int len = str.length();
            check1 = 0;
            check2 = 0;

            // 회문이 아니라면 뒤에 있는 문자열을 하나 빼기
            for(int i = 0; i < len/2; i++) {
                if(check1 == 1) {
                    if(str.charAt(i) != str.charAt(len-i-2)) {
                        check1 = 2;
                        break;
                    }
                } else {
                    if(str.charAt(i) != str.charAt(len-i-1)) {
                        check1 = 1;
                        i--;
                    }
                }
            }

            // 회문이 아니라면 앞에 있는 문자열을 하나 빼기
            for(int i = 0; i < len/2; i++) {
                if(check2 == 1) {
                    if(str.charAt(i+1) != str.charAt(len-i-1)) {
                        check2 = 2;
                        break;
                    }
                } else {
                    if(str.charAt(i) != str.charAt(len-i-1)) {
                        check2 = 1;
                        i--;
                    }
                }
            }

            out.append(Math.min(check1, check2) + "\n");
        }

        System.out.print(out);
    }
}
