package BruteForce;

/*
 * BOJ #1405 미친 로봇
 * https://www.acmicpc.net/problem/1405
 * 브루트포스, DFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class BOJ_1405 {
    
    static int n;
    static double[] percent;
    static boolean[][] visited = new boolean[30][30]; // 상하좌우로 각각 14칸씩 이동할 수 있어야 하므로 30*30 크기로 생성
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static double ans = 0;
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        percent = new double[4];
        for (int i = 0; i < 4; i++) {
            percent[i] = Double.parseDouble(st.nextToken()) / 100.0; // 확률로 계산하여 저장
        }
 
        visited[15][15] = true;
        dfs(15, 15, 0, 1);
 
        System.out.println(ans);
    }
    
    public static void dfs(int x, int y, int cnt, double nowPercent) {
        if (cnt == n) {
            ans += nowPercent; // 확률 누적
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
 
            if (nx < 1 || ny < 1 || nx >= 30 || ny >= 30 || visited[nx][ny]) continue;
 
            visited[nx][ny] = true;
            dfs(nx, ny, cnt+1, nowPercent*percent[i]);
            visited[nx][ny] = false;
        }
    }
}
