package D4;

/**
 * SWEA #7465 창용 마을 무리의 개수
 * union find
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465 {
	
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			parents = new int[n+1];
			for(int i = 1; i < n+1; i++) {
				parents[i] = i;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			int checkNum = 0;
			for(int i = 1; i < parents.length; i++) {
				if(parents[i] > 0) {
					checkNum = find(i);
					for(int j = i+1; j < parents.length; j++) {
						if(find(j) == checkNum) {
							parents[j] = 0; // 중복 탐색 방지
						}
					}
					ans++;
				}
			}
			
			out.append("#" + (t + 1) + " " + ans + "\n");
		}
		
		System.out.print(out);
	}
	
	public static int find(int a) {
    	if(parents[a] == a) return a;
    	else return parents[a] = find(parents[a]);
    }
	
	public static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a != b) parents[b] = a;
    }
}