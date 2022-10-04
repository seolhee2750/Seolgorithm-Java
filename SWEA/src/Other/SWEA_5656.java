package Other;

/*
 * SWEA #5656 벽돌 깨기
 * 시뮬레이션, 구현 + 순열, BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_5656 {
	
	static int n, w, h;
	static int[][] map, memory;
	static boolean[][] visited;
	static int[] nums;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder out = new StringBuilder();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			memory = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < w; j++) {
					int now = Integer.parseInt(st.nextToken());
					map[i][j] = now;
					memory[i][j] = now;
				}
			}
			
			ans = Integer.MAX_VALUE;
			makeSet();
			makePermu(0, new int[n]);
			
			out.append("#" + t + " " + ans + "\n");
		}
		System.out.print(out);
	}
	
	public static void makeSet() { // 0부터 w-1까지, 구슬이 떨어질 수 있는 위치들을 담는 집합 만들기
		nums = new int[w];
		for(int i = 0; i < w; i++) nums[i] = i;
	}
	
	public static void makePermu(int nth, int[] choosed) { // 중복 순열 (구슬이 떨어질 수 있는 위치들의 모든 순열)
		if(nth == choosed.length) {
			oneCase(choosed);
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			choosed[nth] = nums[i];
			makePermu(nth+1, choosed);
		}
	}
	
	public static void oneCase(int[] choosed) { // 하나의 순열에 대한 시뮬레이션
		for(int i = 0; i < n; i++) {
			int y = choosed[i];
			for(int x = 0; x < h; x++) {
				if(map[x][y] > 0) { // 첫 번째 벽돌을 만났을 때
					Deque<int[]> que = new ArrayDeque<>();
					que.add(new int[]{x, y, map[x][y]});
					destroy(que);
					fall();
					break;
				}
			}
		}
		findAns();
		initMap();
	}
	
	public static void destroy(Deque<int[]> que) { // 하나의 구슬에 의한 벽돌들의 부서짐을 표현
		visited = new boolean[h][w];
		while(!que.isEmpty()) {
			int[] now = que.removeFirst();
			int x = now[0];
			int y = now[1];
			int num = now[2];
			for(int i = 0; i < h; i++) { // 상, 하
				if(i < x-num+1 || i > x+num-1 || visited[i][y] == true) continue;
				que.add(new int[]{i, y, map[i][y]});
				map[i][y] = 0;
				visited[i][y] = true;
			}
			for(int i = 0; i < w; i++) { // 좌, 우
				if(i < y-num+1 || i > y+num-1 || visited[x][i] == true) continue;
				que.add(new int[]{x, i, map[x][i]});
				map[x][i] = 0;
				visited[x][i] = true;
			}
		}
	}
	
	public static void fall() { // 하나의 구슬에 대한 벽돌 부숨이 끝나면, 벽들들을 아래로 떨어뜨리기
		for(int y = 0; y < w; y++) {
			for(int x = h-1; x > 0; x--) { // 맨 윗 칸은 빈 칸이어도 떨어뜨릴 벽돌이 없으므로, 맨 윗칸의 바로 아랫칸까지만 탐색
				if(map[x][y] == 0) {
					for(int a = x-1; a >= 0; a--) {
						if(map[a][y] > 0) {
							map[x][y] = map[a][y];
							map[a][y] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
	public static void findAns() { // 남은 벽돌 수를 세고, 최솟값 갱신
		int cnt = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		
		ans = Math.min(ans, cnt);
	}
	
	public static void initMap() { // 하나의 조합에 대한 연산을 끝내면 map 배열 다시 원상복귀
		for(int i = 0; i < h; i++) {
			System.arraycopy(memory[i], 0, map[i], 0, memory[i].length);
		}
	}
}