package Graph;

/**
 * BOJ #21278 호석이 두 마리 치킨
 * https://www.acmicpc.net/problem/21278
 * 조합, 플로이드-워셜
 */

import java.io.*;
import java.util.*;

public class BOJ_21278 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int INF = 100_000_000;
    static int N, M;
    static int[][] dist;

    static int c1 = 0, c2 = 0;
    static int min = INF;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i != j && dist[i][j] == 0) {
                    dist[i][j] = INF;
                }
            }
        }

        // 플로이드-워셜
        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i != j) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        makeCombination(0, new int[2], 0);

        System.out.println((c1 + 1) + " " + (c2 + 1) + " " + min);
    }

    // 조합 찾기
    public static void makeCombination(int nth, int[] result, int startIdx) {
        // 종료시 최솟값 찾기
        if(nth == result.length) {
            findMin(result[0], result[1]);
            return;
        }

        for(int i = startIdx; i < N; i++) {
            result[nth] = i;
            makeCombination(nth+1, result, i+1);
        }
    }

    // 최소가 되는 치킨집 조합 찾기
    public static void findMin(int a, int b) {

        int sum = 0;

        for(int i = 0; i < N; i++) {
            if(i != a && i != b) sum += Math.min(dist[i][a] + dist[a][i], dist[i][b] + dist[b][i]);
            if(sum >= min) return;
        }

        c1 = a;
        c2 = b;
        min = sum;
    }
}
