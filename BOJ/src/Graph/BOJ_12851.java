package Graph;

/**
 * BOJ #12851 숨바꼭질2
 * https://www.acmicpc.net/problem/12851
 * BFS
 * 
 * 동생을 찾았을 때, visited 동생 위치에 저장된 최소 탐색 시간이
 * 현재 경로의 탐색 시간보다 클 경우, 그 최솟값을 갱신, cnt는 1로 초기화했다.
 * 그리고 이미 저장되어있던 값과 현재 경로의 탐색 시간이 같다면 cnt만 증가시켜주었다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_12851 {
	static Deque<int[]> que;
	static int[] visited = new int[100_001];
	static int n, k, cnt;
	
	public static int bfs() {
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int sec = now[1];
			int[] cal = {x+1, x-1, x*2};
			
			for(int i = 0; i < 3; i++) {
				if(cal[i] == k) { // 동생 찾으면 동생 위치의 visited 최솟값 갱신
					if(visited[k] > sec+1) {
						visited[k] = sec+1;
						cnt = 1;
					} else if(visited[k] == sec+1) {
						cnt++;
					}
					continue;
				}
				if(cal[i] < 0 || cal[i] >= visited.length || visited[cal[i]] <= sec) continue;
				
				que.add(new int[]{cal[i], sec+1});
				visited[cal[i]] = sec+1;
			}
		}
		return visited[k];
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());;
		
		if(n == k) System.out.println(0 + "\n" + 1);
		else {
			for(int i = 0; i < visited.length; i++) visited[i] = Integer.MAX_VALUE;
			que = new ArrayDeque<>();
			que.add(new int[]{n, 0});
			
			System.out.println(bfs() + "\n" + cnt);
		}		
	}

}
