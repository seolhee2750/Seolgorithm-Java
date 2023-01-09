package Graph;

/*
 * BOJ #1068 트리
 * https://www.acmicpc.net/problem/1068
 * dfs
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 {
	
	static int n, m;
	static int[] tree;
	static int root;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(in.readLine());
		tree = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] == -1) root = i;
		}
		
		m = Integer.parseInt(in.readLine());
		removeNode(m); // m 노드 및 하위 노드 삭제
		
		if(tree[root] != -2) countLeaf(root); // 루트 노드를 시작으로 리프노드들을 찾음 (루트가 -2일 경우 리프노드는 없음)
		System.out.println(cnt);
	}
	
	public static void removeNode(int node) {
		tree[node] = -2; // 노드 제거
		for(int i = 0; i < n; i++) { 
			if(tree[i] == node) removeNode(i); // 삭제된 node를 부모로 가지는 자식 node
		}
	}
	
	public static void countLeaf(int start) {
		boolean isLeaf = true;
		for(int i = 0; i < n; i++) {
			if(tree[i] == start) {
				countLeaf(i);
				isLeaf = false;
			}
		}
		if(isLeaf) cnt++;
	}
}