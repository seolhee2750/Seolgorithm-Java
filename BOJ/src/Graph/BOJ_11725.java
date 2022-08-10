package Graph;

/**
 * BOJ #11725 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 * DFS
 * 루트노드인 1부터 탐색하며 부모 자식 관계를 찾아주었다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725 {

	static int n;
	static ArrayList<Integer>[] tree;
	static int[] result;
	
	public static void dfs(int parent) {
		for(int i = 0; i < tree[parent].size(); i++) {
			int now = tree[parent].get(i);
			if(result[now] > 0) continue; // 이미 부모 찾은 경우
			result[now] = parent + 1; // 부모 찾았으니 기록
			dfs(now);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		result = new int[n];
		tree = new ArrayList[n];
		for(int i = 0; i < n; i++) tree[i] = new ArrayList<>();
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			tree[a].add(b);
			tree[b].add(a);
		}
		
		result[0] = 1;
		dfs(0);
		
		for(int i = 1; i < n; i++) {
			out.append(result[i]);
			if(i < n-1) out.append("\n");
		}
		System.out.println(out);
	}

}
