package Graph;

/*
 * BOJ #1584 게임
 * https://www.acmicpc.net/problem/1584
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1584 {

    static class Info implements Comparable<Info> {
        int x;
        int y;
        int dis;

        public Info(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Info o) {
            return this.dis - o.dis;
        }
    }

    static int n, m;
    static int[][] map = new int[501][501];
    static int ans = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 위험한 구역
        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fillDanger(x1, y1, x2, y2);
        }

        // 죽음의 구역
        st = new StringTokenizer(in.readLine());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            fillDeath(x1, y1, x2, y2);
        }

        bfs();
        System.out.println(ans);
    }

    public static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        PriorityQueue<Info> que = new PriorityQueue<>();
        que.add(new Info(0, 0, 0));

        int[][] visited = new int[501][501];
        for(int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        while(!que.isEmpty()) {
            Info now_info = que.poll();
            int x = now_info.x;
            int y = now_info.y;
            int dis = now_info.dis;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 예외
                if(nx < 0 || ny < 0 || nx > 500 || ny > 500 || map[nx][ny] == 2) continue;

                // 갈 가치가 있는 길인지 확인
                int nDis = dis + map[nx][ny];
                if(nDis >= visited[nx][ny]) continue;

                visited[nx][ny] = nDis;
                if(nx == 500 && ny == 500) {
                    ans = visited[500][500];
                    continue;
                }
                que.add(new Info(nx, ny, nDis));
            }
        }
    }

    public static void fillDanger(int x1, int y1, int x2, int y2) {
        int min_x = Math.min(x1, x2);
        int min_y = Math.min(y1, y2);
        int max_x = Math.max(x1, x2);
        int max_y = Math.max(y1, y2);

        for(int i = min_x; i < max_x+1; i++) {
            for(int j = min_y; j < max_y+1; j++) {
                map[i][j] = 1;
            }
        }
    }

    public static void fillDeath(int x1, int y1, int x2, int y2) {
        int min_x = Math.min(x1, x2);
        int min_y = Math.min(y1, y2);
        int max_x = Math.max(x1, x2);
        int max_y = Math.max(y1, y2);

        for(int i = min_x; i < max_x+1; i++) {
            for(int j = min_y; j < max_y+1; j++) {
                map[i][j] = 2;
            }
        }
    }
}
