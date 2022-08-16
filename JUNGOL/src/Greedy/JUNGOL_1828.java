package Greedy;

/**
 * JUNGOL #1828 냉장고
 * http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
 * 그리디
 * 
 * 최대 온도 순으로 오름차순 정렬, 최대 온도 같을 시 최저 온도 순으로 오름차순 정렬한 뒤
 * 겹치는 부분이 있는지 확인해주며 냉장고 개수를 세어줬다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1828 {
	static int n;

	static class Refrigerator implements Comparable<Refrigerator>{
		int low, high;

		public Refrigerator(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Refrigerator o) {
			return this.high != o.high ? this.high - o.high : this.low - o.low;
		}	
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(in.readLine());
		
		Refrigerator[] r = new Refrigerator[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			r[i] = new Refrigerator(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(r); // 최대 온도 기준 정렬
		int cnt = 1;
		int max = r[0].high;
		for (int i = 1; i < r.length; i++) {
			if(r[i].low > max) {
				max = r[i].high;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}