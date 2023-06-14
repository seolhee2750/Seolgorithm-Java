package Graph;

/**
 * BOJ #1325 효율적인 해킹
 * https://www.acmicpc.net/problem/1325
 * BFS
 *
 * [1] 어떤 컴퓨터를 해킹할 수 있을지가 아니라, [2] 해킹 당할 수 있을지!로 생각해야 함
 * 전자의 방식으로 풀 경우 시간초과 발생함
 *
 * [1]
 * A 컴퓨터가 B 컴퓨터를 신뢰할 경우, B 컴퓨터를 해킹했을 때 A 컴퓨터까지 해킹이 가능하기 때문에
 * 처음에는 B 컴퓨터의 리스트에 A를 추가하는 방식으로 인접리스트를 구성해주었지만
 * 이 방식 사용 시, 예를 들어 1 -> 2 -> 3 과정의 해킹을 탐색 후에 2 -> 3 의 해킹을 또 탐색하게 되는 중복이 발생하게 됨
 *
 * [2]
 * 따라서 반대로 생각하여 A 컴퓨터가 B 컴퓨터를 신뢰할 경우, A 컴퓨터는 B 컴퓨터에 의해 해킹이 가능하다는 사실에 집중함으로써
 * 3번이 해킹당할 수 있는 2번에 ++, 또 2번이 해킹당할 수 있는 1번에 ++ 하는 방식으로 1씩 더해가며 총 해킹 가능 개수를 세어야 함
 */

import java.io.*;
import java.util.*;

public class BOJ_1325 {

    static int N, M;
    static ArrayList<Integer>[] list;

    static int max;
    static int[] cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            list[i] = new ArrayList <Integer>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
        }

        cnt = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            BFS(i);
        }

        for(int num: cnt) {
            if (max < num) {
                max = num;
            }
        }

        StringBuilder out = new StringBuilder();
        for(int i = 1; i < N+1; i++) {
            if(max == cnt[i]) {
                out.append(i + " ");
            }
        }

        System.out.println(out);
    }

    static void BFS(int start) {

        Deque<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()) {
            int now = que.poll();
            for(int i : list[now]) {
                if(!visited[i]) {
                    visited[i] = true;
                    cnt[i]++;
                    que.add(i);
                }
            }
        }
    }
}
