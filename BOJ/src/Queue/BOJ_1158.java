package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()) - 1;
		
		Deque<Integer> que = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) que.add(i);
		
		int idx = 0;
		out.append("<");
		while(!que.isEmpty()) {
			if(idx++ == k) {
				idx = 0;
				if(que.size() == 1) out.append(que.removeFirst());
				else out.append(que.removeFirst() + ", ");
			}
			else que.add(que.removeFirst());
		}
		System.out.println(out.append(">"));
	}

}