package BruteForce;

/**
 * BOJ #2003 수들의 합 2
 * https://www.acmicpc.net/problem/2003
 * 투 포인터
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
	
	static int n, m;
	static int[] nums;
	static int a, b, sum, cnt;
	
	public static int twoPointer() {
		while(true) {
			if(a == n || b == n) return cnt;
			sum += nums[b];
			if(sum >= m) {
				if(sum == m) cnt++;
				while(sum >= m) { // 다시 sum이 m보다 작아질 때까지 a 포인터 이동
					sum -= nums[a];
					if(sum == m) cnt++;
					a++;
				}
			}
			b++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(twoPointer());	
	}

}
