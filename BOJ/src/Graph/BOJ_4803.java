package Graph;

/**
 * BOJ #4803 트리
 * https://www.acmicpc.net/problem/4803
 * DFS로 풀이 !
 * 싸이클을 이루는 간선이 있는지 없는지만 체크해주면 됨
 * 
 * 주의 사항
 * 재귀호출 시 그냥 호출만 하면 안됨 !!!
 * 추후 진행되는 탐색에서 false 발생 시 false를 반환하도록 해주어야 함
 * 싸이클은 모두 이어지는 것이기 때문에 현재 true이고 후에 false가 된다면 false이기 때문 !!!
 * 
 * 도움받은 반례
 * https://www.acmicpc.net/board/view/66586
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_4803 {

	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int n, m;
	static int cnt;
	
	public static boolean dfs(int start, int num) {
		for(int i: map[num]) { // 입력되는 숫자가 이어진 노드들 모두 확인
			if(i == start) continue; // 출발점(이전 노드) 만나면 무시
			if(visited[i]) return false; // 이미 방문한 곳 재방문 -> 싸이클 발생 !!
			visited[i] = true; // 방문 체크
			if(!dfs(num, i)) return false; // 재귀 호출 (여기 그냥 호출만 하면 안됨)
		}
		return true; // 트리 하나 찾음
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int idx = 0;
		while(true) {
			idx++;
			cnt = 0;
			
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0) break; // 반복 종료 조건
			
			visited = new boolean[n];
			map = new ArrayList[n];
			for(int i = 0; i < n; i++) {
				map[i] = new ArrayList<>(); // ArrayList타입의 2차원 배열 만들기
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				map[a].add(b);
				map[b].add(a);
			}
			
			for(int i = 0; i < n; i++) {
				if(!visited[i]) {
					visited[i] = true;
					if(dfs(-1, i)) cnt++; // 트리 찾으면 cnt++
				}
			}
			
			out.append("Case " + idx + ": ");
			if(cnt == 0) out.append("No trees.\n");
			else if(cnt == 1) out.append("There is one tree.\n");
			else out.append("A forest of " + cnt + " trees.\n");
		}
		
		System.out.println(out);
	}

}
