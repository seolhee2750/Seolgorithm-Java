package Implementation;

/*
 * BOJ #14719 빗물
 * https://www.acmicpc.net/problem/14719
 * 구현, 시뮬레이션
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {

	static int w, h;
	static int map[][];
	static int ans;
	
	static class Hole {
		int x1;
		int y1;
		int x2;
		int y2;
		
		public Hole(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < w; i++) {
			int now = Integer.parseInt(st.nextToken());
			for(int j = h-1; j > h-now-1; j--) {
				map[j][i] = 1;
			}
		}
		
		findHole();
		System.out.println(ans);
	}
	
	public static void findHole() {
		Hole hole = new Hole(-1, -1, -1, -1);
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] == 1) {
					if(hole.x1 == -1) {
						hole.x1 = i;
						hole.y1 = j;
					} else {
						if(map[i][j] == 2) {
							hole.x1 = -1;
							hole.x2 = -1;
						} else {
							hole.x2 = i;
							hole.y2 = j;
							raining(hole);
							hole = new Hole(i, j, -1, -1); // 새로운 웅덩이 시작
						}
					}
				}
			}
		}
	}
	
	public static void raining(Hole hole) {
		for(int i = hole.x1; i < hole.x2+1; i++) {
			for(int j = hole.y1; j < hole.y2+1; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 2;
					ans++;
				}
			}
		}
	}
}
