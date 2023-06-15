package Graph;

/**
 * BOJ #5567 결혼식
 * https://www.acmicpc.net/problem/5567
 * BFS
 */

import java.util.*;
import java.io.*;

public class BOJ_5567 {

    static int n, m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int cnt;

    public static class Friend {

        int num;
        int depth;

        public Friend(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());

        list = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        bfs();
        System.out.println(cnt);
    }

    static void bfs() {

        Deque<Friend> que = new ArrayDeque<>();
        visited = new boolean[n+1];

        // 상근이
        que.add(new Friend(1, 0));
        visited[1] = true;

        while(!que.isEmpty()) {
            Friend now = que.poll();
            for(int l: list[now.num]) {
                if(!visited[l] && now.depth < 2) {
                    visited[l] = true;
                    que.add(new Friend(l, now.depth+1));
                    cnt++;
                }
            }
        }
    }
}
