package BinarySearch;

/*
 * BOJ #10816 숫자 카드 2
 * https://www.acmicpc.net/problem/10816
 * 이분 탐색
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10816 {

	static int n, m;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		n = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		m = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			out.append(upper(num) - lower(num) + " ");
		}
		
		System.out.println(out);
	}
	
	public static int upper(int num) {
		int min = 0;
		int max = list.size();
		
		while(min < max) {
			int mid = (min + max) / 2;
			
			if(num < list.get(mid)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		return min;
	}
	
	public static int lower(int num) {
		int min = 0;
		int max = list.size();
		
		while(min < max) {
			int mid = (min + max) / 2;
			
			if(num <= list.get(mid)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		return min;
	}
}
