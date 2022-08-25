package D4;

/**
 * SWEA #3289 서로소 집합
 * union find
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {
	
	static int n, m, parents[];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			out.append("#" + (t + 1) + " ");
			
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			parents = new int[n];	
			for(int i = 0; i < n; i++) {
				parents[i] = i;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine());
				int order = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				if(order == 0) {
					union(a, b);
				} else {
					if(find(a) == find(b)) {
						out.append(1);
					} else {
						out.append(0);
					}
				}
			}
			out.append("\n");			
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
