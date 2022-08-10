package Implementation;

/**
 * BOJ #17406 배열 돌리기 4
 * https://www.acmicpc.net/problem/17406
 * 구현
 * 입력되는 회전 연산을 모두 받은 뒤, 그 순서에 대한 순열을 만들고
 * 하나의 순열이 완성될 때마다 그에 해당하는 회전연산을 진행하며 최솟값을 갱신했다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
	
	static int n, m, k;
	static int[][] nums;
	static int[][] cals;
	static int min;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] numsTmp;
	static int cnt = 0;
	
	public static int turn(int[][] res) {
		numsTmp = new int[n][m];
		for(int i = 0; i < n; i++) { // 깊은 복사
			for(int j = 0; j < m; j++) {
				numsTmp[i][j] = nums[i][j];
			}
		}
		
		for(int[] now: res) {
			int r = now[0];
			int c = now[1];
			int s = now[2];
			int[] point1 = {r-s-1, c-s-1}; // 가장 좌측 상단 꼭지점
			int[] point2 = {r+s-1, c+s-1}; // 가장 우측 하단 꼭지점
			int turnNum = Math.min(point2[0]-point1[0]+1, point2[1]-point1[1]+1) / 2; // 회전하는 띠의 개수
			
			for(int i = 0; i < turnNum; i++) { // 가장 좌측 상단 꼭지점을 tmp로 두고 시계방향 회전
				int x = point1[0] + i;
				int y = point1[1] + i;
				int startX = x;
				int startY = y;
				int tmp = numsTmp[x][y];
				int dir = 0;
				
				while(dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					if(nx < point1[0]+i || ny < point1[1]+i || nx > point2[0]-i || ny > point2[1]-i) {
						dir++;
						continue;
					}
					
					numsTmp[x][y] = numsTmp[nx][ny];
					x = nx;
					y = ny;
				}
				
				numsTmp[startX][startY+1] = tmp;
			}
		}
		
		int minSum = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int minTmp = 0;
			for(int j = 0; j < m; j++) {
				minTmp += numsTmp[i][j];
			}
			minSum = Math.min(minSum, minTmp);
		}
		return minSum; // 현재 수열의 회전 연산을 마친 배열의 값 리턴
	}
	
	public static void permu(int[][] res, boolean[] visited, int depth) {
		if(depth == k) {
			min = Math.min(min, turn(res)); // 현재 만든 수열에 해당하는 회전 연산 진행
			return;
		}
		
		for(int i = 0; i < k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				res[depth] = cals[i];
				permu(res, visited, depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		nums = new int[n][m];
		cals = new int[k][3];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			cals[i][0] = Integer.parseInt(st.nextToken());
			cals[i][1] = Integer.parseInt(st.nextToken());
			cals[i][2] = Integer.parseInt(st.nextToken());
		}
		
		permu(new int[k][3], new boolean[k], 0); // 수열 만들면서, 수열 완성할 때마다 회전 연산
		
		System.out.println(min);
	}
}