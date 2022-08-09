package D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_1954 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		//  오른쪽, 아래, 왼쪽, 위쪽 순으로 돌 수 있도록 값 설정 (시계 방향)
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		
		for (int t = 0; t < tc; t++) {
			int num = 1;
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			
			int x = 0;
			int y = 0;
			int way = 0; // 방향
			
			// n의 제곱이 될 때까지 반복
			while(num <= (n * n)) {
				arr[x][y] = num++;
				
				x += dx[way];
				y += dy[way];
				
				// 범위를 벗어나거나, 이미 채워진 자리를 만날 시, x, y값을 다시 되돌린 후 방향을 바꿔주어 움직이도록 함
				if(x > n-1 || x < 0 || y > n-1 || y < 0 || arr[x][y] != 0) {
					x -= dx[way];
					y -= dy[way];				

					way = (way + 1) % 4;

					x += dx[way];
					y += dy[way];
				}
			}
			
			// 결과 출력
			sb.append("#" + (t + 1) + "\n");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}