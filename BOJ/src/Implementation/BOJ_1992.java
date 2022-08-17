package Implementation;

/**
 * BOJ #1992 쿼드트리
 * https://www.acmicpc.net/problem/1992
 * 분할 정복, 재귀
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992 {
	
	static int n;
	static String map[][];
	static StringBuilder out = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		map = new String[n][n];
		for(int i = 0; i < n; i++) {
			String s = in.readLine();
			map[i] = s.split("");
		}
		quadTree(0, 0, n);
		System.out.println(out);
	}
	
	public static void quadTree(int r, int c, int size) {
		if(check(r, c, size)) {
			out.append(map[r][c]);
			return;
		}
		int newSize = size/2;
		out.append("(");
		quadTree(r, c, newSize);
		quadTree(r, c+newSize, newSize);
		quadTree(r+newSize, c, newSize);
		quadTree(r+newSize, c+newSize, newSize);
		out.append(")");
	}
	
	public static boolean check(int r, int c, int size) {
		for(int i = r; i < r+size; i++) {
			for(int j = c; j < c+size; j++) {
				if(!map[i][j].equals(map[r][c])) return false;
			}
		}
		return true;
	}

}
