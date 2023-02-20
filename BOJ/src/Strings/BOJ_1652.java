package Strings;

/*
 * BOJ #1652 누울 자리를 찾아라
 * https://www.acmicpc.net/problem/1652
 * 문자열, 구현
 */

import java.io.*;

public class BOJ_1652 {
	
	static int n;
	static char[][] map;
	static int columnCnt, rowCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		map = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = in.readLine();
			map[i] = str.toCharArray();
		}
		
		checkColumn();
		checkRow();
		
		System.out.println(columnCnt + " " + rowCnt);
	}
	
	// 가로 체크
	public static void checkColumn() {
		int allSeat = 0;
		for(int i = 0; i < n; i++) {
			int seat = 0;
			for(int j = 0; j < n; j++) {
				if(map[i][j] == '.') {
					if(seat == 0) {
						seat++;
					} else if (seat == 1) {
						allSeat++;
						seat = -1;
					}
				} else {
					seat = 0;
				}
			}
		}
		columnCnt += allSeat;
	}
	
	// 세로 체크
	public static void checkRow() {
		int allSeat = 0;
		for(int i = 0; i < n; i++) {
			int seat = 0;
			for(int j = 0; j < n; j++) {
				if(map[j][i] == '.') {
					if(seat == 0) {
						seat++;
					} else if(seat == 1) {
						allSeat++;
						seat = -1;
					}
				} else {
					seat = 0;
				}
			}
		}
		rowCnt += allSeat;
	}
}