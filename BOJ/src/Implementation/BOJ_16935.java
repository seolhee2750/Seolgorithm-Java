package Implementation;

/**
 * BOJ #16935 배열 돌리기 3
 * https://www.acmicpc.net/problem/16935
 * 구현
 * 배열을 돌릴 때마다 가로, 세로의 길이가 달라질 수 있다는 점만 체크하기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {
	
	static int n, m, r;
	static int[][] nums;
	static int[] dx, dy;
	static int[][] result;
	static int tmp;
	
	public static void turn(int cal) {
		switch(cal) {
		case 1: // 상하 반전
			for(int x = 0; x < n/2; x++) {
				for(int y = 0; y < m; y++) {
					tmp = nums[x][y];
					nums[x][y] = nums[n-1-x][y];
					nums[n-1-x][y] = tmp;
				}
			}
			break;
		case 2: // 좌우 반전
			for(int y = 0; y < m/2; y++) {
				for(int x = 0; x < n; x++) {
					tmp = nums[x][y];
					nums[x][y] = nums[x][m-1-y];
					nums[x][m-1-y] = tmp;
				}
			}
			break;
		case 3: // 오른쪽으로 90도 회전
			result = new int[m][n];
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < m; y++) {
					result[y][n-1-x] = nums[x][y];
				}
			}
			nums = result;
			n = nums.length;
			m = nums[0].length;
			break;
		case 4: // 왼쪽으로 90도 회전
			result = new int[m][n];
			n = result.length;
			m = result[0].length;
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < m; y++) {
					result[x][y] = nums[y][n-1-x];
				}
			}
			nums = result;
			break;
		case 5: // 그룹 오른쪽으로 90도 회전
			dx = new int[]{0, (n/2), 0, -(n/2)};
			dy = new int[]{(m/2), 0, -(m/2), 0};
			result = new int[n][m];
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < m; y++) {
					if(x < n/2 && y < m/2) result[x+dx[0]][y+dy[0]] = nums[x][y]; // 1 -> 2
					else if(x < n/2 && y >= m/2) result[x+dx[1]][y+dy[1]] = nums[x][y]; // 2 -> 3
					else if(x >= n/2 && y >= m/2) result[x+dx[2]][y+dy[2]] = nums[x][y]; // 3 -> 4
					else result[x+dx[3]][y+dy[3]] = nums[x][y]; // 4 -> 1
				}
			}
			nums = result;
			break;
		case 6: // 그룹 왼쪽으로 90도 회전
			dx = new int[]{(n/2), 0, -(n/2), 0};
			dy = new int[]{0, -(m/2), 0, (m/2)};
			result = new int[n][m];
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < m; y++) {
					if(x < n/2 && y < m/2) result[x+dx[0]][y+dy[0]] = nums[x][y]; // 1 -> 4
					else if(x < n/2 && y >= m/2) result[x+dx[1]][y+dy[1]] = nums[x][y]; // 2 -> 1
					else if(x >= n/2 && y >= m/2) result[x+dx[2]][y+dy[2]] = nums[x][y]; // 3 -> 2
					else result[x+dx[3]][y+dy[3]] = nums[x][y]; // 4 -> 3
				}
			}
			nums = result;
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());;
		nums = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < m; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < r; i++) {
			int now = Integer.parseInt(st.nextToken());
			turn(now);
		}
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[0].length; j++) {
				out.append(nums[i][j]);
				if(j < nums[0].length-1) out.append(" ");
			}
			out.append("\n");
		}
		System.out.println(out);
	}

}
