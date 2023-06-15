package Graph;

/**
 * BOJ #1245 농장 관리
 * https://www.acmicpc.net/problem/1245
 * DFS
 *
 * 0이 아닌 모든 지점을 탐색하면서 해당 지점이 봉우리가 맞는지! 확인해주는 방식으로 구현함
 * 특정 지점에서 DFS로 8방 탐색을 진행하다가,
 * 나보다 낮은 격자를 만난다면 무시하고, 나보다 높은 격자를 만난다면 나는 봉우리가 아닌 것으로 판단해주었고,
 * 나와 같은 높이의 격자를 만난다면 같은 봉우리로 보아 방문 체크 후 해당 위치에서 다시 DFS를 호출해주었음
 */

import java.util.*;
import java.io.*;

public class BOJ_1245 {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};
    static boolean isPeak = true;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j);
                    if(isPeak) {
                        cnt++;
                    } else {
                        isPeak = true;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int x, int y) {

        // 8방 탐색
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 지도를 벗어남
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            // 봉우리가 아님
            if(map[nx][ny] > map[x][y]) {
                isPeak = false;
                continue;
            }

            // 하나의 봉우리에 포함됨
            if(map[nx][ny] == map[x][y] && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}
