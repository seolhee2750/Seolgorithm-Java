package D4;

/**
 * SWEA #1238 Contact
 * BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class SWEA_1238 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder out = new StringBuilder();
         
        for(int t = 1; t <= 10; t++) {
            st = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int[] calls = new int[l];
            int max = 0;
             
            st = new StringTokenizer(in.readLine());
            for(int i = 0; i < l; i++) {
                calls[i] = Integer.parseInt(st.nextToken()) - 1;
                if(max < calls[i]) max = calls[i];
            }
             
            Set<Integer>[] memory = new HashSet[max+1];
            for(int i = 0; i < memory.length; i++) {
                memory[i] = new HashSet<>(); // HashSet 타입의 2차원 배열 만들기
            }
             
            for(int i = 0; i < calls.length; i += 2) {
                memory[calls[i]].add(calls[i+1]);
            }
             
            int[] visited = new int[max+1];
            Deque<int[]> que = new ArrayDeque<>();
            if(memory[s].size() == 0) { // 시작 당번이 가리키는 사람 없는 경우
                out.append("#" + t + " " + (s + 1) + "\n");
            }
            else { // BFS
                for(int m: memory[s]) { // 시작 당번이 가리키는 사람들을 que에 추가
                    que.add(new int[]{m, 1});
                }
                 
                while(!que.isEmpty()) {
                    int now[] = que.removeFirst();
                    int start = now[0]; // 현재 출발 당번
                    int cnt = now[1]; // 현재 당번까지의 전화 횟수
                     
                    if(visited[start] > 0) continue;
                    visited[start] = cnt;
                     
                    if(memory[start].size() == 0) continue;
                    for(int m: memory[start]) {
                        que.add(new int[]{m, cnt+1});
                    }
                }
                 
                int maxValue = 0;
                int answer = 0;
                for(int i = 0; i < visited.length; i++) {
                    if(maxValue < visited[i]) {
                        maxValue = visited[i];
                        answer = i + 1;
                    } else if(maxValue == visited[i]) {
                        answer = Math.max(answer, i+1);
                    }
                }
                 
                out.append("#" + t + " " + answer + "\n");
            }
        }
         
        System.out.print(out);
    }
}
