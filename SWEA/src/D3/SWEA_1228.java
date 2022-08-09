package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		for(int t = 0; t < 10; t++) {
			int n = Integer.parseInt(in.readLine());
			
			LinkedList<String> list = new LinkedList<>();
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < n; i++) list.add(st.nextToken());
			
			int m = Integer.parseInt(in.readLine());
			
			int idx = 0;
			st = new StringTokenizer(in.readLine());
			while(idx < m) {
				String now = st.nextToken();
				
				if(!now.equals("I")) {
					int y = Integer.parseInt(st.nextToken());
					for(int i = 0; i < y; i++) {
						list.add(Integer.parseInt(now)+i, st.nextToken());
					}
					idx++;
				}
			}
			
			out.append("#").append((t+1)).append(" ");
			for(int i = 0; i < 10; i++) {
				out.append(list.get(i)).append(" ");
			}
			out.append("\n");
		}
		
		System.out.println(out);
	}

}
