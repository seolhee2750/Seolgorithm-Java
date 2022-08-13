package Other;

/**
 * SWEA #4012 요리사
 * https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AYHg4cRqHpADFAV6&contestProbId=AWIeUtVakTMDFAVH&probBoxId=AYJ7e5KK4AIDFAVG&type=PROBLEM&problemBoxTitle=8%EC%9B%94+2%EC%A3%BC&problemBoxCnt=7
 * 조합
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static int[][] nums;
	static int n;
	static int[] toCombi;
	static int min;
	
	public static void cook(int[] choosed, int[] notChoosed) {
		int food1 = 0;
		int food2 = 0;
		for(int i = 0; i < choosed.length; i++) {
			for(int j = 0; j < choosed.length; j++) {
				if(i == j) continue;
				food1 += (nums[choosed[i]][choosed[j]]);
				food2 += (nums[notChoosed[i]][notChoosed[j]]);
			}
		}
		min = Math.min(min, Math.abs(food1 - food2));
	}
	
	public static void combi(int nth, int[] choosed, boolean[] visited, int start) {
		if(nth == choosed.length) {
			int[] notChoosed = new int[choosed.length];
			int idx = 0;
			for(int i = 0; i < visited.length; i++) {
				if(!visited[i]) notChoosed[idx++] = i;
			}
			cook(choosed, notChoosed);
			return;
		}
		for(int i = start; i < toCombi.length; i++) {
			choosed[nth] = toCombi[i];
			visited[toCombi[i]] = true;
			combi(nth+1, choosed, visited, i+1);
			visited[toCombi[i]] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer out = new StringBuffer();
		
		int tc = Integer.parseInt(in.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(in.readLine());
			nums = new int[n][n];
			toCombi = new int[n];
			min = Integer.MAX_VALUE;
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(in.readLine());
				for(int j = 0; j < n; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			for(int i = 0; i < n; i++) toCombi[i] = i;
			combi(0, new int[n/2], new boolean[n], 1);
			out.append("#" + t + " " + min + "\n");
		}
		
		System.out.print(out);
	}

}
