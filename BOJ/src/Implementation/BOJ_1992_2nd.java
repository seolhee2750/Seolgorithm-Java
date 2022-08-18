package Implementation;

/**
 * BOJ #1992 쿼드트리 [두 번째 풀이]
 * https://www.acmicpc.net/problem/1992
 * 분할 정복, 재귀
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1992_2nd {
	
	static StringBuilder out = new StringBuilder();
	static int n;
	static String[][] map;
	
	public static boolean check(int depth, int x, int y) {
		String standard = map[x][y];
		for(int i = x; i < x+depth; i++) {
			for(int j = y; j < y+depth; j++) {
				if(!standard.equals(map[i][j])) return false;
			}
		}
		return true;
	}
	
	private static void QuadTree(int depth, int x, int y) {
		if(check(depth, x, y)) out.append(map[x][y]);
		else {
			out.append("(");
			depth /= 2;
			int[] dx = {0, 0, depth, depth};
			int[] dy = {0, depth, 0, depth};
			for(int i = 0; i < 4; i++) {
				QuadTree(depth, x+dx[i], y+dy[i]);
			}
			out.append(")");
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		map = new String[n][n];
		for(int i = 0; i < n; i++) {
			map[i] = in.readLine().split("");
		}
		
		QuadTree(n, 0, 0);
		System.out.println(out);
	}
}
