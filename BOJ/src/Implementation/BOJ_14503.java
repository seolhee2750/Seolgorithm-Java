package Implementation;

/*
 * BOJ #14503 로봇 청소기
 * https://www.acmicpc.net/problem/14503
 * 구현, 시뮬레이션
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503 {

	static int r, c, d;
	static int n, m;
	static int[][] map;
	static int cnt = 0;
	
	public static boolean move() {
		boolean success = false; // 청소할 자리를 찾았는지 여부
		findWay:
		for(int i = 0; i < 4; i++) { // 왼쪽으로 회전 (마지막 반복엔 다시 제자리)
			if(d == 0) { // 상 -> 좌
				d = 3;
				if(check(r, c-1)) {
					c--; // 청소기 이동
					success = true;
				}
			} else if(d == 1) { // 우 -> 북
				d = 0;
				if(check(r-1, c)) {
					r--; // 청소기 이동
					success = true;
				}
			} else if(d == 2) { // 하 -> 우
				d = 1;
				if(check(r, c+1)) {
					c++; // 청소기 이동
					success = true;
				}
			} else if(d == 3) {	// 좌 -> 하
				d = 2;
				if(check(r+1, c)) {
					r++; // 청소기 이동
					success = true;
				}
			}
			
			if(success) { // 청소할 곳 찾았을 때
				map[r][c] = 2; // 청소
				cnt++;
				return true;
			}
		}
		
		if(!goBack()) { // 후진
			return false; // 후진할 수 없을 때
		}
		
		return true;
	}
	
	// 앞으로 가고자 하는 자리가 청소할 수 있는 자리인지 판단
	public static boolean check(int x, int y) {
		if(map[x][y] > 0) { // 청소할 수 없는 자리
			return false;
		} else return true;
	}
	
	// 후진할 수 있는지 판단, 위치 이동
	public static boolean goBack() {
		if(d == 0) r++;
		else if(d == 1) c--;
		else if(d == 2) r--;
		else if(d == 3) c++;
		
		if(map[r][c] == 1) { // 후진 불가
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		map[r][c] = 2;
		cnt++;
		while(move()) {}
		
		System.out.println(cnt);
	}
}