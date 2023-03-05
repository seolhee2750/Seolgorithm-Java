package Strings;

/*
 * BOJ #12904 A와 B
 * https://www.acmicpc.net/problem/12904
 * 문자열, 그리디
 */

import java.io.*;

public class BOJ_12904 {
	
	static StringBuilder s, t;
	static int sLen;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		s = new StringBuilder(in.readLine());
		t = new StringBuilder(in.readLine());
		sLen = s.length();
		
		game();
	}
	
	public static void game() {
		if(t.length() == sLen) {
			if(t.toString().equals(s.toString())) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			return;
		}
	
		if(t.charAt(t.length()-1) == 'A') {
			t.deleteCharAt(t.length()-1);
		} else {
			t.deleteCharAt(t.length()-1);
			t.reverse();
		}
		
		game();
	}
}
