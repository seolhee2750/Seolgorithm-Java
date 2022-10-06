package Graph;

/*
 * BOJ #9205 맥주 마시면서 걸어가기
 * https://www.acmicpc.net/problem/9205
 * 플로이드 워셜로 풀이
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9205 {
	
	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static int[][] distance;
	static boolean[][] check;
	static List<Node> nodes;
	
	public static void floyd() { // 플로이드 워셜
		for (int i = 0; i < n + 2; i++) {
        	for (int j = 0; j < n + 2; j++) {
        		for (int k = 0; k < n + 2; k++)
                    if (check[j][i] && check[i][k]) check[j][k] = true; // (i -> k 가능, k -> j 가능) == (i -> j 가능)
        	}
        }
	}
	
	public static void distanceCheck() {
		for (int i = 0; i < n + 2; i++) {
        	for (int j = 0; j < n + 2; j++) {
                Node n1 = nodes.get(i);
                Node n2 = nodes.get(j);
                
                distance[i][j] = Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y); // 맨해튼 거리
                if (distance[i][j] <= 1000) check[i][j] = true; // 맥주 한 박스를 가지고 한 번에 갈 수 있는 거리 == 1000
            }
        }
	}

    public static void main(String[] args) throws Exception {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
    	StringBuilder out = new StringBuilder();
    	
        int tc = Integer.parseInt(in.readLine());
        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(in.readLine());
            distance = new int[n + 2][n + 2];
            check = new boolean[n + 2][n + 2];
            nodes = new ArrayList<>();
            for (int i = 0; i <= n + 1; i++) {
            	st = new StringTokenizer(in.readLine());
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());
                nodes.add(new Node(x, y));
            }

            distanceCheck();
            floyd();           
            out.append((check[0][n + 1] ? "happy" : "sad") + "\n");
        }
        System.out.println(out);
    }
}