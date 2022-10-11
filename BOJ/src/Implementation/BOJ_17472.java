package Implementation;

/*
 * BOJ #17472 다리 만들기 2
 * https://www.acmicpc.net/problem/17472
 * 구현, BFS, 크루스칼
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17472 {
	
	public static class Node { // 좌표
	    int x;
	    int y;
	    
	    public Node(int x, int y) {
	        this.x = x;
	        this.y = y ;
	    }
	}

	public static class Line implements Comparable<Line> { // 간선
	    int s;
	    int e;
	    int v;
	    
	    public Line(int s, int e, int v) {
	        this.s = s;
	        this.e = e;
	        this.v = v;
	    }

		@Override
		public int compareTo(Line o) {
			return this.v - o.v;
		}
	}
    
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int island = 0; // 섬 번호
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Deque<Node> que; // BFS를 위함
    static PriorityQueue<Line> pq = new PriorityQueue<Line>(); // 크루스칼을 위함
    static int[] parents;
    static int ans = 0; // 결과
    static int cnt = 0; // 다리 개수
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1. 섬을 번호로 구분
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    island++;
                    que = new ArrayDeque<>();
                    que.add(new Node(i, j));
                    visited[i][j] = true;
                    map[i][j] = island;
                    bfs();
                }
            }
        }        
        
        // 2. 가능한 모든 다리 만들기
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
            	if(map[i][j] != 0) makeBridge(new Node(i,j), map[i][j]);
            }
        }
        
        // 3. 크루스칼
        kruskal();
        
        System.out.println(cnt != island - 1 ? -1 : ans);
    }
 
    public static void bfs() {
        while(!que.isEmpty()) {
            Node t = que.poll();
            int x = t.x;
            int y = t.y;
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] != 1 || visited[nx][ny]) continue;

                que.add(new Node(nx,ny));
                map[nx][ny] = island;
                visited[nx][ny] = true;
            }   
        }
    }
    
    public static void makeBridge(Node node, int num) {
        int x = node.x;
        int y = node.y;
        int len = 0;
        
        for(int i = 0; i < 4; i++) { // 상하좌우 한 방향씩 다른 섬 나올 때까지 탐색
            while(true) {
                x += dx[i];
                y += dy[i];
                
                if(x < 0 || y < 0 || x >= n || y >= m || map[x][y] == num || (map[x][y] > 0 && len < 2)) { // 범위를 벗어나거나, 같은 섬이거나, 다른 섬이지만 다리의 길이가 2 미만일 때
                	len = 0;
                    x = node.x;
                    y = node.y;
                    break;
                }
                
                if(map[x][y] == 0) { // 바다일 때
                	len++;
                } else if(len >= 2) { // 다른 섬을 만났으며, 다리의 크기가 2 이상일 때
                	pq.add(new Line(num, map[x][y], len));
                	len = 0;
                    x = node.x;
                    y = node.y;
                    break;
                }
            }
        }
        
      
    }
    
    public static void kruskal() {
    	parents = new int[island + 1];
        for(int i = 1; i < island+1; i++) {
            parents[i] = i;
        }
        
        while(!pq.isEmpty()) {
        	Line tmp = pq.poll();
            int a = find(tmp.s);
            int b = find(tmp.e);
            
            if(a == b) continue;
            union(tmp.s, tmp.e);
            ans += tmp.v;
            cnt++;
        }
    }
    
    public static int find(int a) {
        if(a == parents[a]) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }
    
    public static void union(int s, int e) {
        int a = find(s);
        int b = find(e);
        
        if(a != b) parents[a] = b;
        else return;
    }
}