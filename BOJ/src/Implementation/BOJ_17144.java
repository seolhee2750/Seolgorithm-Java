package Implementation;

/*
 * BOJ #17144 미세먼지 안녕!
 * https://www.acmicpc.net/problem/17144
 * 구현, 시뮬레이션
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17144 {

	static int r, c, t, air, total;
	static int[][] room;
	static Deque<int[]> que = new ArrayDeque<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void solution() {
		for(int sec = 0; sec < t; sec++) {
			while(!que.isEmpty()) { // 미세먼지 확산
				int[] now = que.poll(); // 미세먼지의 x, y좌표, 양
				int x = now[0];
				int y = now[1];
				int w = now[2];
				int cnt = 0; // 몇 개 칸으로 확산했는지
				
				for(int i = 0; i < 4; i++) { // 각 미세먼지마다 주변으로 확산시켜주기
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx < 0 || ny < 0 || nx >= r || ny >= c || room[nx][ny] == -1) continue;
					cnt++;
					room[nx][ny] += w / 5;
				}
				
				room[x][y] -= (w / 5 * cnt);
			}
			
			wind(); // 공기청정기 작동
			
			for(int i = 0; i < r; i++) { // 다시 미세먼지들의 위치 확인, 큐에 넣어주기
				for(int j = 0; j < c; j++) {
					if(room[i][j] > 0) que.add(new int[]{i, j, room[i][j]});
				}
			}
		}
	}
	
	public static void wind() { // 공기청정기 바람 순환
		for(int i = air-1; i > 0; i--) room[i][0] = room[i-1][0]; // 위에서 아래로 넣어주기
		for(int i = 0; i < c-1; i++) room[0][i] = room[0][i+1]; // 오른쪽에서 왼쪽으로 넣어주기
		for(int i = 0; i < air; i++) room[i][c-1] = room[i+1][c-1]; // 아래쪽에서 위쪽으로 넣어주기
		for(int i = c-1; i > 1; i--) room[air][i] = room[air][i-1]; // 왼쪽에서 오른쪽으로 넣어주기
		room[air][1] = 0;
		
		for(int i = (air+1)+1; i < r-1; i++) room[i][0] = room[i+1][0]; // 아래쪽에서 위쪽으로 넣어주기				
		for(int i = 0; i < c-1; i++) room[r-1][i] = room[r-1][i+1]; // 오른쪽에서 왼쪽으로 넣어주기
		for(int i = r-1; i > (air+1); i--) room[i][c-1] = room[i-1][c-1]; // 위에서 아래로 넣어주기
		for(int i = c-1; i > 1; i--) room[(air+1)][i] = room[(air+1)][i-1]; // 왼쪽에서 오른쪽으로 넣어주기
		room[(air+1)][1] = 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		room = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < c; j++) {
				int now = Integer.parseInt(st.nextToken());
				room[i][j] = now;
				if(now > 0) que.add(new int[]{i, j, now});
				if(now == -1 && air == 0) air = i; // 공기청정기는 무조건 1열이므로 x좌표 값만 넘겨주기
			}
		}
		
		solution();
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(room[i][j] > 0) total += room[i][j];
			}
		}
		
		System.out.println(total);
	}
}

