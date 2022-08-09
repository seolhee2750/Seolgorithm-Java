package Graph;

/**
 * BOJ #9466 텀 프로젝트
 * https://www.acmicpc.net/problem/9466
 * DFS로 풀이 !
 * 싸이클을 찾고, 싸이클을 이루는 학생 수를 찾아주면 됨
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {

	static int[] stu;
	static boolean[] cycle, visited;
	static int cnt; // 싸이클에 포함된 학생 수
	
	public static void dfs(int num) {
		if(visited[num]) { // 이미 방문한 경우 (싸이클 !!!)
			cycle[num] = true;
			cnt++;
		} else visited[num] = true; // 첫 방문은 방문 체크
		
		if(!cycle[stu[num]]) dfs(stu[num]); // 다음 노드가 사이클에 포함되지 않았다면 탐색
		cycle[num] = true; // 다음 탐색 시 중복을 피하기 위함
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			int n = Integer.parseInt(in.readLine());
			stu = new int[n];
			visited = new boolean[n];
			cycle = new boolean[n];
			cnt = 0;
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) stu[i] = Integer.parseInt(st.nextToken()) - 1;
			for(int i = 0; i < n; i++) if(!cycle[i]) dfs(i); // 싸이클에 포함되지 않은 수면 탐색
			
			out.append((n - cnt) + "\n"); // 전체 학생 수 - 사이클에 포함된 학생 수
		}
		
		System.out.println(out);
	}
}
