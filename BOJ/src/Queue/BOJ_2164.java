package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2164 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Integer> que = new ArrayDeque<>();
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= n; i++) que.add(i);
		
		int idx = 1;
		while(que.size() > 1) {
			if(idx % 2 == 0) que.add(que.removeFirst());
			else que.removeFirst();
			idx++;
		}
		
		System.out.println(que.removeFirst());

	}

}
