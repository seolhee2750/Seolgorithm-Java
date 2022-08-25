package D4;

/*
 * SWEA #3124 최소 스패닝 트리
 * 프림
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder out = new StringBuilder();
	static int V, E;
	static List<Node>[] graph;
	
	public static void main(String[] args) throws Exception {
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점
			E = Integer.parseInt(st.nextToken()); // 간선
			
			graph = new ArrayList[V];
			for(int i = 0; i < V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				
				graph[a].add(new Node(b, c));
				graph[b].add(new Node(a, c));
			}
			
			prim(t+1);
		}
		
		System.out.print(out);
	}
	
	public static void prim(int t) {
		long totalCost = 0;
		int nodeCnt = 0;
		boolean[] visited = new boolean[V];
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node minCostHead = pq.poll();
			if(visited[minCostHead.no]) continue;
			visited[minCostHead.no] = true;
			totalCost += minCostHead.cost;
			nodeCnt++;
			
			if(nodeCnt == V) break;
			
			for(Node n: graph[minCostHead.no]) {
				if(visited[n.no]) continue;
				pq.offer(n);
			}
		}
		
		out.append("#" + t + " " + totalCost + "\n");
	}
	
	static class Node implements Comparable<Node> {
		int no;
		int cost;
		
		public Node(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

}
