package Graph;

/**
 * BOJ #1956 운동
 * https://www.acmicpc.net/problem/1956
 * 플로이드-워셜
 */

import java.io.*;
import java.util.*;

public class BOJ_1956 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int INF = 100_000_000;
    static int V, E;
    static int[][] dist;
    static int min = INF;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(in.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V][V];
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(i != j) {
                    dist[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }

        for(int k = 0; k < V; k++) {
            for(int i = 0; i < V; i++) {
                for(int j = 0; j < V; j++) {
                    if(i != j) {
                        if(dist[i][k] + dist[k][j] > 0) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }

        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(i != j) {
                    // 시작점에서 끝점, 그리고 끝점에서 시작점으로 돌아오는 경로가 모두 존재해야만 사이클이 있는 것으로 볼 수 있음
                    if(dist[i][j] != INF && dist[i][j] !=INF) {
                        min = Math.min(min, dist[i][j] + dist[j][i]);
                    }
                }
            }
        }

        min = (min == INF ? -1 : min);
        System.out.println(min);
    }
}
