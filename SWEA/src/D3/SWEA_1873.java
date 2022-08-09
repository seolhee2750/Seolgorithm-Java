package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873 {
	
	static char[][] map;
	static int h, w;
	static char[] skils;
	
	public static void game() {
		int x = 0; // 전차 x 좌표
		int y = 0; // 전차 y 좌표
		int dir = 0; // 왼, 오, 위, 아래
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		
		// 시작점 찾기
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
					x = i;
					y = j;
					if(map[i][j] == '<') dir = 0;
					if(map[i][j] == '>') dir = 1;
					if(map[i][j] == '^') dir = 2;
					if(map[i][j] == 'v') dir = 3;
				}
			}
		}
		
		for(char s: skils) {
			switch(s) {
			case 'U':
				dir = 2;
				map[x][y] = '^';
				if(x-1 >= 0 && map[x-1][y] == '.') {
					map[x-1][y] = map[x][y];
					map[x][y] = '.';
					x -= 1;
				}
				break;
			case 'D':
				dir = 3;
				map[x][y] = 'v';
				if(x+1 < h && map[x+1][y] == '.') {
					map[x+1][y] = map[x][y];
					map[x][y] = '.';
					x += 1;
				}
				break;
			case 'L':
				dir = 0;
				map[x][y] = '<';
				if(y-1 >= 0 && map[x][y-1] == '.') {
					map[x][y-1] = map[x][y];
					map[x][y] = '.';
					y -= 1;
				}
				break;
			case 'R':
				dir = 1;
				map[x][y] = '>';
				if(y+1 < w && map[x][y+1] == '.') {
					map[x][y+1] = map[x][y];
					map[x][y] = '.';
					y += 1;
				}
				break;
			case 'S':
				int nx = x;
				int ny = y;
				while(true) {
					nx += dx[dir];
					ny += dy[dir];
					
					if(nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == '#') break;
					if(map[nx][ny] == '*') {
						map[nx][ny] = '.';
						break;
					}
				}
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(in.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			map = new char[h][];
			for(int i = 0; i < h; i++) {
				map[i] = in.readLine().toCharArray();
			}
			
			int n = Integer.parseInt(in.readLine());
			skils = in.readLine().toCharArray();
			
			game();
			
			System.out.print("#" + (t + 1) + " ");
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
					if(j == w-1) System.out.print("\n");
				}
			}
		}
		
	}

}
