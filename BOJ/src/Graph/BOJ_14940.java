package Graph;

/*
 * BOJ #14940 쉬운 최단거리
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_14940 {

    static int n, m;
    static int[][] map, ans;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void bfs(int a, int b) {
        boolean[][] visited = new boolean[n][m];
        Deque<Node> que = new ArrayDeque<>();
        visited[a][b] = true;
        que.add(new Node(a, b, 1));

        while(!que.isEmpty()) {
            Node now = que.removeFirst();
            int x = now.x;
            int y = now.y;
            int cnt = now.cnt;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                ans[nx][ny] = cnt;
                que.add(new Node(nx, ny, cnt+1));
            }
        }

        // 도달할 수 없는 위치
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1) ans[i][j] = -1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder out = new StringBuilder();

        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        ans = new int[n][m];

        Node end = new Node(0, 0, 0);
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) end = new Node(i, j, 0);
            }
        }

        ans[end.x][end.y] = 0;
        bfs(end.x, end.y);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                out.append(ans[i][j]);
                if(j != m-1) out.append(" ");
                else out.append("\n");
            }
        }
        System.out.print(out);
    }
}
