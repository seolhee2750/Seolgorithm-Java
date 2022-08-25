package Graph;

/**
 * BOJ #10026 적록색약
 * https://www.acmicpc.net/problem/10026
 * DFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ_10026 {
	
	static int n, cnt;
	static char[][] map, tmp;
	static Deque<int[]> que = new ArrayDeque<>();
	
	public static void dfs(int x, int y, char color) {
		if(x < 0 || y < 0 || x >= n || y >= n) return;
		if(color != tmp[x][y]) return;
		
		tmp[x][y] = 'F'; // 중복 방지
		
		dfs(x, y-1, color);
		dfs(x, y+1, color);
		dfs(x-1, y, color);
		dfs(x+1, y, color);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		map = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = in.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		tmp = new char[n][n];
		for(int i = 0; i < n; i++) tmp[i] = Arrays.copyOf(map[i], n);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(tmp[i][j] != 'F') {
					dfs(i, j, tmp[i][j]);
					cnt++;
				}
			}
		}
		out.append(cnt + " ");
		cnt = 0;
		
		for(int i = 0; i < n; i++) tmp[i] = Arrays.copyOf(map[i], n);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(tmp[i][j] == 'G') tmp[i][j] = 'R';
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(tmp[i][j] != 'F') {
					dfs(i, j, tmp[i][j]);
					cnt++;
				}
			}
		}
		out.append(cnt);
		
		System.out.println(out);
	}

}
