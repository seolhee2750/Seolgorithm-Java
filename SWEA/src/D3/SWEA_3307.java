package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307 {

	static int n;
	static int[] nums, lis;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(in.readLine());
			nums = new int[n];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			lis = new int[n];
			int max = 0;
			for(int i = 0; i < lis.length; i++) {
				lis[i] = 1; // 1. 최소한 자기 스스로는 1짜리 lis
				for(int j = 0; j < i; j++) { // 2. 이전에 찾았던 lis 중에서 끼어들어갈 여지가 있는가?
					if(nums[i] > nums[j] && lis[i] < lis[j]+1) {
						lis[i] = lis[j] + 1;
					}
				}
				max = Math.max(max, lis[i]);
			}
			out.append(String.format("#%d %d\n", t, max));
		}
		System.out.println(out);
	}
}
