package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 0; t < tc; t++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] nums = new int[n];
			st = new StringTokenizer(in.readLine());			
			for(int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for(int i = 0; i < n-1; i++) {
				for(int j = i+1; j < n; j++) {
					int tmp = nums[i] + nums[j];
					if(tmp <= m && max < tmp) max = tmp;
				}
			}
			
			if(max == 0) max = -1;
			out.append("#" + (t+1) + " " + max + "\n");
		}
		
		System.out.println(out);
	}

}
