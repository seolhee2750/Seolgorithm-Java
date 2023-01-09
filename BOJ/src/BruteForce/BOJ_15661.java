package BruteForce;

/*
 * BOJ 15661 링크와 스타트
 * https://www.acmicpc.net/problem/15661
 * 브루트포스, 부분집합으로 풀이
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661 {

    static int n;
    static int[][] nums;
    static int result = Integer.MAX_VALUE;

    static void makeSet(int toCheck, boolean[] checked) {
        if(toCheck == checked.length) {
            makeResult(checked);
            return;
        }

        checked[toCheck] = true;
        makeSet(toCheck+1, checked);
        checked[toCheck] = false;
        makeSet(toCheck+1, checked);
    }

    static void makeResult(boolean[] checked) {
        int a = 0, b = 0;

        for(int i = 0; i < n-1; i++) {
            if(checked[i]) { // a팀 (true)
                for (int j = i + 1; j < n; j++) {
                    if(checked[j]) a += (nums[i][j] + nums[j][i]);
                }
            } else { // b팀 (false)
                for (int j = i + 1; j < n; j++) {
                    if(!checked[j]) b += (nums[i][j] + nums[j][i]);
                }
            }
        }

        int tmp = Math.abs(a - b);
        if(tmp < result) result = tmp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(in.readLine());
        nums = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSet(1, new boolean[n]);
        System.out.println(result);
    }
}