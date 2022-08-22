package DP;

/**
 * BOJ #1149 RGB거리
 * https://www.acmicpc.net/problem/1149
 * DP
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1149 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		
		ArrayList<Integer> red = new ArrayList<>();
		ArrayList<Integer> blue = new ArrayList<>();
		ArrayList<Integer> green = new ArrayList<>();
		red.add(0);
		blue.add(0);
		green.add(0);
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			red.add(Math.min(green.get(i), blue.get(i)) + r);
			blue.add(Math.min(red.get(i), green.get(i)) + b);
			green.add(Math.min(red.get(i), blue.get(i)) + g);
		}
		
		System.out.println(Math.min(Math.min(red.get(red.size()-1),  blue.get(blue.size()-1)), green.get(green.size()-1)));
	}

}
