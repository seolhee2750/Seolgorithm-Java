package Implementation;

/*
 * BOJ 2239 스도쿠
 * https://www.acmicpc.net/problem/2239
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239 {
	
	static int[][] map = new int[9][9];
	static List<int[]> empty = new ArrayList<>(); // 빈 칸 리스트
	
	public static void sudoku(int cnt) {
		if(cnt == empty.size()) { // 빈 칸 다 채우면 (게임 종료 처리)
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		// 현재 위치 (빈 칸)
		int x = empty.get(cnt)[0];
		int y = empty.get(cnt)[1];
		// 현재 위치하는 사각형의 시작점
		int startX = x / 3 * 3;
		int startY = y / 3 * 3;
		// x, y 지점의 상하좌우 및 사각형 안에 있는 숫자들을 체크
		boolean[] check = new boolean[9];
		
		for(int i = 0; i < 9; i++) {
			if(map[x][i] > 0) check[map[x][i]-1] = true; // 좌우
			if(map[i][y] > 0) check[map[i][y]-1] = true; // 상하
		}
		for(int i = startX; i < startX+3; i++) {
			for(int j = startY; j < startY+3; j++) {
				if(map[i][j] > 0) check[map[i][j]-1] = true; // 사각형 안
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(!check[i]) { // 사용되지 않은 수 발견 시, 현재 위치에 해당하는 수를 넣어보고 sudoku 재귀 호출 (모든 경우의 수 따져보기)
				map[x][y] = i+1;
				sudoku(cnt+1);
				map[x][y] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 9; i ++) {
			String str = in.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 0) empty.add(new int[]{i, j});
			}
		}
		
		sudoku(0);
	}
}
