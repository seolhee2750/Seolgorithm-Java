package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] result = new int[n];
		Deque<int[]> que = new ArrayDeque<>();
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			if(i == 0 || que.size() == 0) {
				result[i] = 0;
				que.add(new int[]{i, now});
				continue;
			}
			else {
				// 이전 수가 더 큰 경우
				if(que.getLast()[1] > now) {
					result[i] = que.getLast()[0] + 1;
					que.add(new int[]{i, now});
				}
				// 이전 수가 더 작은 경우
				else {
					while(que.size() > 0) {
						if(que.getLast()[1] < now) que.removeLast(); // 더 큰 수 만날 때까지 뒤에서부터 값 삭제
						else {
							result[i] = que.getLast()[0] + 1; // 더 큰 수 만났을 때
							break;
						}
					}
					que.add(new int[]{i, now});
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			out.append(result[i]);
			if(i < n-1) out.append(" ");
		}
		
		System.out.println(out);

	}

}
