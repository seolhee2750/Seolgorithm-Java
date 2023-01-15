package Implementation;

/*
 * BOJ #15658 연산자 끼워넣기 (2)
 * https://www.acmicpc.net/problem/15658
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15658 {

	static int n;
	static int[] nums, cals;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		nums = new int[n];
		cals = new int[4];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < 4; i++) {
			cals[i] = Integer.parseInt(st.nextToken());
		}

		calculation(1, nums[0]);
		System.out.println(max + "\n" + min);
	}
	
	public static void calculation(int idx, int sum) {
		if(idx == n) {
			if(sum < min) min = sum;
			if(sum > max) max = sum;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(cals[i] == 0) continue;
			cals[i]--;
			switch(i) {
				case 0:
					calculation(idx+1, sum+nums[idx]);
					break;
				case 1:
					calculation(idx+1, sum-nums[idx]);
					break;
				case 2:
					calculation(idx+1, sum*nums[idx]);
					break;
				case 3:
					calculation(idx+1, sum/nums[idx]);
					break;
			}
			cals[i]++;	
		}
	}
}