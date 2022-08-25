package Graph;

/*
 * BOJ #16236 아기 상어
 * https://www.acmicpc.net/problem/16236
 * 시뮬레이션 + BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_16236 {

	static int n;
	static int[][] map;
	static int[] start;
	static int cnt, shark, ans;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static int[] bfs(Deque<int[]> que, int[][] visited, int[] fish) {
		while(!que.isEmpty()) {
			int now[] = que.removeFirst();
			int x = now[0];
			int y = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] > shark || visited[nx][ny] > 0) continue;
				visited[nx][ny] = visited[x][y] + 1;
				
				if(map[nx][ny] < shark && map[nx][ny] > 0) { // 상어보다 작은 물고기 만났을 때 => 기존에 먹으려고 했던 물고기보다 적합한지 확인 후, 먹을 물고기 업데이트
					if(fish[2] == 0 ||
							fish[2] > visited[nx][ny] ||
							(fish[2] == visited[nx][ny] && (fish[0] > nx || (fish[0] == nx && fish[1] > ny)))) {
						fish[0] = nx;
						fish[1] = ny;
						fish[2] = visited[nx][ny];
					}
				}
				
				que.add(new int[]{nx, ny});
			}
		}
		return fish;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) start = new int[]{i, j}; // 아기 상어의 위치
			}
		}
		
		shark = 2;
		while(true) {
			Deque<int[]> que = new ArrayDeque<>();
			que.add(start);
			
			int[][] visited = new int[n][n];
			visited[start[0]][start[1]] = 1;
			map[start[0]][start[1]] = 0;
			
			int[] now = bfs(que, visited, new int[]{0, 0, 0});
			if(now[2] == 0) { // 더이상 먹을 물고기 없을 때
				System.out.println(ans);
				return;
			}
			
			ans += now[2]-1;
			cnt++; // 물고기 먹는데 걸린 시간 누적
			if(cnt == shark) {
				cnt = 0;
				shark++; // 상어 크기만큼 물고기 먹으면 상어 크기 키워주기
			}
			map[now[0]][now[1]] = 0; // 방금 먹힌 물고기의 위치는 빈 칸으로 만들어주기
			start = Arrays.copyOf(now, 2); // 아기 상어의 위치를 방금 먹은 물고기 위치로 옮겨주기
		}
	}
}
