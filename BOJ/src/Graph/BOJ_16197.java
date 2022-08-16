package Graph;

/**
 * BOJ #16197 두 동전
 * https://www.acmicpc.net/problem/16197
 * BFS
 * 
 * 두 개의 동전을 하나의 쌍처럼 생각하고, 두 개씩 BFS 탐색을 해주었음
 * 동전이 둘 다 나가게 되는 경우, 하나만 나가게 되는 경우, 벽을 마주하는 경우를 예외로 처리
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16197 {
	
	static int n, m;
	static char[][] board;
	static Deque<int[]> que;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static int bfs() {
		mainLoop:
		while(true) {
			int[] coin1 = que.removeFirst();
			int[] coin2 = que.removeFirst();
			if(coin1[2] > 10) break;
			
			for(int i = 0; i < 4; i++) {
				int nx1 = coin1[0] + dx[i];
				int ny1 = coin1[1] + dy[i];
				int nx2 = coin2[0] + dx[i];
				int ny2 = coin2[1] + dy[i];
				
				// 동전이 둘 다 나가는 경우
				if((nx1 < 0 || ny1 < 0 || nx1 >= n || ny1 >= m) && (nx2 < 0 || ny2 < 0 || nx2 >= n || ny2 >= m)) continue;
				
				// 동전이 하나만 나가는 경우
				if(((nx1 < 0 || ny1 < 0 || nx1 >= n || ny1 >= m) && (nx2 >= 0 && ny2 >= 0 && nx2 < n && ny2 < m)) ||
						((nx1 >= 0 && ny1 >= 0 && nx1 < n && ny1 < m) && (nx2 < 0 || ny2 < 0 || nx2 >= n || ny2 >= m))) return coin1[2];
				
				if(board[nx1][ny1] == '#') que.add(new int[]{coin1[0], coin1[1], coin1[2]+1});
				else que.add(new int[]{nx1, ny1, coin1[2]+1});
				
				if(board[nx2][ny2] == '#') que.add(new int[]{coin2[0], coin2[1], coin2[2]+1});
				else que.add(new int[]{nx2, ny2, coin2[2]+1});
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new char[n][m];
		que = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			String now = in.readLine();
			for(int j = 0; j < m; j++) {
				board[i][j] = now.charAt(j);
				if(now.charAt(j) == 'o') que.add(new int[]{i, j, 1}); // x좌표, y좌표, 버튼 클릭 횟수 카운트
			}
		}
		
		System.out.println(bfs());
	}

}
