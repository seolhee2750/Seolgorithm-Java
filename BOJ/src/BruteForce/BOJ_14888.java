package BruteForce;

/*
 * BOJ #14888 연산자 끼워넣기
 * https://www.acmicpc.net/problem/14888
 * 브루트포스, 순열
 * 
 * 재귀호출로 훨씬 효율적으로 풀 수 있음!!!
 * 나중에 다시 한 번 풀어보자.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	
	static int n;
	static int[] nums;
	static int[] cals_nums = new int[4];
	static int[] cals;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		nums = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < 4; i++) {
			int now = Integer.parseInt(st.nextToken());
			cals_nums[i] = now;
		}
		
		cals = new int[n-1];
		int idx = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < cals_nums[i]; j++) {
				cals[idx] = i; // 각 연산자의 개수만큼 연산자를 추가
				idx++;
			}
		}
		
		makePermu(0, new int[n-1], new boolean[n-1]);
		System.out.println(max + "\n" + min);
	}
	
	public static void makePermu(int nth, int[] choosed, boolean[] visited) {
		if(nth == choosed.length) {
			calculation(choosed);
			return;
		}
		
		for(int i = 0; i < cals.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			choosed[nth] = cals[i];
			makePermu(nth+1, choosed, visited);
			visited[i] = false;
		}
	}
	
	public static void calculation(int[] choosed) {
		int tmp = nums[0];
		for(int i = 0; i < n-1; i++) {
			switch(choosed[i]) {
				case 0:
					tmp = tmp + nums[i+1];
					break;
				case 1:
					tmp = tmp - nums[i+1];
					break;
				case 2:
					tmp = tmp * nums[i+1];
					break;
				case 3:
					if(tmp > 0) {
						tmp = tmp / nums[i+1];
					} else {
						tmp = -tmp;
						tmp = tmp / nums[i+1];
						tmp = -tmp;
					}
					break;
			}
		}
		
		if(min > tmp) min = tmp;
		if(max < tmp) max = tmp;
	}
}
