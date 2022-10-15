package BruteForce;

/*
 * BOJ #14225 부분수열의 합
 * https://www.acmicpc.net/problem/14225
 * 브루트포스, 부분집합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14225 {
	
	static int n, allSum;
	static int[] nums;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		nums = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			allSum += nums[i];
		}
		
		makeSubSet(0, 0);
		findAns();
	}
	
	public static void makeSubSet(int toCheck, int sum) {
		if(toCheck == n) {
			pq.add(sum);
			pq.add(allSum - sum);
			return;
		}
		
		makeSubSet(toCheck+1, sum + nums[toCheck]);
		makeSubSet(toCheck+1, sum);
	}
	
	public static void findAns() {
		int last = 0;
		while(!pq.isEmpty()) {
			int now = pq.poll();
			if(now == 0) {
				continue;
			} else {
				if(now - last >= 2) break;
				else last = now;
			}
		}
		System.out.println(last+1);
	}
}