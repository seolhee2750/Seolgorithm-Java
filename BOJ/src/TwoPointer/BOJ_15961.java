package TwoPointer;

/*
 * BOJ #15961 회전 초밥
 * https://www.acmicpc.net/problem/15961
 * 슬라이딩 윈도우
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {
	
	static int n, d, k, c; // 접시 수, 초밥 종류, 연속해서 먹는 접시 수, 쿠폰
	static int susi[], ate[]; // 벨트에 놓인 초밥 종류, 초밥 별 먹은 개수
	static int cnt, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		susi = new int[n];
		ate = new int[d+1];
		for(int i = 0; i < n; i++) {
			susi[i] = Integer.parseInt(in.readLine());
		}
		
		eat();
		System.out.println(ans);
	}
	
	public static void eat() { // 슬라이딩 윈도우
		for(int i = 0; i < k; i++) {
			if(ate[susi[i]] == 0) ans++;
			ate[susi[i]]++;
		}
		cnt = ans;
		ans = (ate[c] > 0) ? cnt : cnt + 1;
		
		int start = k;
		while(start != n-1+k) {
			if(--ate[susi[(start - k) % n]] == 0) cnt--;
			if(ate[susi[start % n]]++ == 0) cnt++;
			ans = Math.max(ans, (ate[c] > 0) ? cnt : cnt + 1);
			start++;
		}
	}
}