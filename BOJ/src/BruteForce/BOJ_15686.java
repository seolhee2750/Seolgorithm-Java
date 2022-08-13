package BruteForce;

/**
 * BOJ #15686 치킨 배달
 * https://www.acmicpc.net/problem/15686
 * 조합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
	
	static int n, m;
	static int[] map;
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	
	public static void findMin(int[][] choosed) {
		int sum = 0;
		for(int[] h: house) {
			int tmp = Integer.MAX_VALUE;
			for(int[] c: choosed) {
				tmp = Math.min(tmp, Math.abs(h[0]-c[0]) + Math.abs(h[1]-c[1]));
			}
			sum += tmp;
		}
		answer = Math.min(answer, sum);
	}
	
	public static void combi(int nth, int[][] choosed, int start) {
		if(nth == choosed.length) {
			findMin(choosed);
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			choosed[nth] = chicken.get(i);
			combi(nth+1, choosed, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < n; j++) {
				int now = Integer.parseInt(st.nextToken());
				map[i][j] = now;
				if(now == 1) house.add(new int[]{i, j});
				else if(now == 2) chicken.add(new int[]{i, j});
			}
		}
		
		combi(0, new int[m][2], 0);
		System.out.println(answer);
	}

}
