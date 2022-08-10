package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ #16926 배열 돌리기 1
 * https://www.acmicpc.net/problem/16926
 * 구현
 * 정가운데에 있는(하나 이상의 변의 크기가 홀수일 때) 인덱스를 제외하고,
 * 중심을 기준으로 띠를 이루는 인덱스들이 하나의 그룹으로 회전을 할 수 있도록 했음
 */

public class BOJ_16926 {
	
	static int[][] nums;
	static int n, m, r, turnNum;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void turn() {
		for(int i = 0; i < turnNum; i++) { // 띠마다 가장 좌측상단을 tmp로 설정하여 회전
			int x = i;
			int y = i;
			int tmp = nums[i][i];
			int dir = 0; // 범위를 벗어날 때마다 dir을 바꿔주어 방향 전환
			
			while(dir < 4) {
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx < i || ny < i || nx >= n-i || ny >= m-i) { // 범위 벗어날 시 방향 전환
					dir++; 
					continue;
				}
				
				nums[x][y] = nums[nx][ny];
				x = nx;
				y = ny;
			}
			
			nums[i+1][i] = tmp;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		turnNum = Math.min(n, m) / 2; // 회전시켜야 하는 띠의 개수
		nums = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) nums[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < r; i++) turn();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				out.append(nums[i][j]);
				if(j < m-1) out.append(" ");
			}
			out.append("\n");
		}
		System.out.println(out);
	}

}
