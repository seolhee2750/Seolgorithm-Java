package DP;

/*
 * BOJ #17070 파이프 옮기기 1
 * https://www.acmicpc.net/problem/17070
 * DP, 재귀
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17070 {

	static int n;
	static int memory[][];
	
	// 가로, 세로, 대각 순서대로 탐색
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	
	public static void move(int x, int y, int type) {
		if(type == 0 || type == 1) { // 가로 or 세로
			for(int i = 0; i < 2; i++) {
				int j = type; // 가로일 때는 가로, 세로일 때는 세로를 탐색
				if(i == 1) j = 2; // 가로, 세로 모두 대각선 탐색 필요
				
				int nx = x + dx[j];
				int ny = y + dy[j];
				if(check(nx, ny, j)) {
					memory[nx][ny] += 1; // 경우의 수 누적
					move(nx, ny, j); // 탐색할 x, y 좌표와 새롭게 나아갈 파이프의 타입
				}
			}
		} else if(type == 2) { // 대각
			for(int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(check(nx, ny, i)) {
					memory[nx][ny] += 1; // 경우의 수 누적
					move(nx, ny, i); // 탐색할 x, y 좌표와 새롭게 나아갈 파이프의 타입
				}
			}
		}
	}
	
	public static boolean check(int x, int y, int type) {
		if(x < 0 || y < 0 || x >= n || y >= n || memory[x][y] == -1) { // 범위를 벗어나거나, 벽일 때
			return false;
		} 
		if(type == 2 && (memory[x-1][y] == -1 || memory[x][y-1] == -1)) { // 대각선일 때는 나아갈 방향 뿐만 아니라 아래, 오른쪽도 모두 비어있어야 함
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		memory = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				int now = Integer.parseInt(st.nextToken());
				if(now == 1) {
					memory[i][j] = -1;
				}
			}
		}
		
		if(memory[n-1][n-1] == -1) {
			System.out.println(0);
		} else {
			memory[0][0] = 1;
			memory[0][1] = 1;
			move(0, 1, 0); // x, y좌표, 파이프 type
			System.out.println(memory[n-1][n-1]);
		}
	}
}