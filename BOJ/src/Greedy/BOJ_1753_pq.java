package Greedy;

/**
 * BOJ #1753 최단경로
 * https://www.acmicpc.net/problem/1753
 * 다익스트라
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_pq {
	
	static class Node {
		int to, weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int V, E, S;
	static List<Node>[] list;
	static int[] dis;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder out = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		S = Integer.parseInt(in.readLine()) - 1; // 시작 정점
		
		dis = new int[V];
		visited = new boolean[V];
		list = new ArrayList[V];
		for(int i = 0 ; i < V ; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1; // u
			int to = Integer.parseInt(st.nextToken()) - 1; // v
			int weight = Integer.parseInt(st.nextToken()); // 가중치
			
			list[from].add(new Node(to, weight)); // 유향 처리
		}
		
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[S] = 0; // 시작점만 0으로 만들기
		Dijk();
		
		for(int i = 0; i < V ; i++) {
			if(dis[i] == Integer.MAX_VALUE) out.append("INF" + "\n");
			else out.append(dis[i] + "\n");
		}
		
		System.out.print(out);
	}
	
	public static void Dijk() { // 다익스트라
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight)); // 가중치 기준 정렬
		pq.offer(new Node(S, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(dis[now.to] < now.weight) continue;
					
			for(int i = 0; i < list[now.to].size(); i++) {
				Node next = list[now.to].get(i);
				
				if(dis[next.to] > now.weight + next.weight) {
					dis[next.to] = now.weight + next.weight;
					pq.offer(new Node(next.to, dis[next.to]));
				}
			}
		}
	}
}