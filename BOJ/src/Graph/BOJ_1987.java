package Graph;

/**
 * BOJ #1987 알파벳
 * https://www.acmicpc.net/problem/1987
 * DFS
 * 
 * 각 인덱스가 순서대로 알파벳을 의미하는 alphabet 배열을 만들어 방문 체크 용도로 사용했다.
 * dfs를 돌며 alphabet 배열에서 해당하는 알파벳이 이미 쓰였는지 확인하며 카운팅했다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	
	static int r, c;
	static char[][] board;
	static int max = 0;
	
	public static void dfs(int x, int y, boolean[] alphabet, int cnt) {
		if(x < 0 || y < 0 || x >= r || y >= c) return;
		if(alphabet[(int)board[x][y]-65]) { // 이미 쓰여진 알파벳 만날 시 리턴
			max = Math.max(max, cnt);
			return;
		}
		
		alphabet[(int)board[x][y]-65] = true; // 현재 알파벳이 쓰였음을 표시
		dfs(x-1, y, alphabet, cnt+1);
		dfs(x, y-1, alphabet, cnt+1);
		dfs(x+1, y, alphabet, cnt+1);
		dfs(x, y+1, alphabet, cnt+1);
		alphabet[(int)board[x][y]-65] = false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new char[r][c];
		for(int i = 0; i < r; i++) {
			String now = in.readLine();
			for(int j = 0; j < c; j++) {
				board[i][j] = now.charAt(j);
			}
		}
		
		dfs(0, 0, new boolean[26], 0);
		System.out.println(max);
	}

}
