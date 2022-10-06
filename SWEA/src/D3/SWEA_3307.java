package D3;

/*
 * SWEA #3307 최장증가부분수열
 * BS로 풀이
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_3307 {
	
	static List<Integer> lis;
	
	public static int BS(int start, int end, int value) { 
		int s = start;
		int e = end;
		int m = 0;
		
		while(s < e) {
			m = (s + e) / 2;
			if(value <= lis.get(m)) e = m;
			else s = m + 1;
		}
		
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(in.readLine());
			int[] nums = new int[n];
			lis = new ArrayList<>();
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < n; i++) {
				if(lis.isEmpty() || lis.get(lis.size()-1) < nums[i]) lis.add(nums[i]);
				else lis.set(BS(0, lis.size()-1, nums[i]),  nums[i]);
			}
			
			out.append("#" + t + " " + lis.size() + "\n");
		}
		System.out.print(out);
	}
}
