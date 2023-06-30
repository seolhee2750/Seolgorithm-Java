package Graph;

/**
 * BOJ #11265 끝나지 않는 파티
 * 플로이드-워셜
 * https://www.acmicpc.net/problem/11265
 */

import java.io.*;
import java.util.*;

public class BOJ_11265 {

    static int N, M;
    static int[][] dist;
    static int A, B, C;

    static String ENJOY = "Enjoy other party\n";
    static String STAY = "Stay here\n";

    public static void main (String[]args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuilder out = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            A = Integer.parseInt(st.nextToken()) - 1;
            B = Integer.parseInt(st.nextToken()) - 1;
            C = Integer.parseInt(st.nextToken());

            if (dist[A][B] <= C) {
                out.append(ENJOY);
            } else {
                out.append(STAY);
            }
        }

        System.out.print(out);
    }
}
