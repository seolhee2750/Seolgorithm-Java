package D4;

import java.util.Scanner;

public class SWEA_1210 {
    
	public static int find(int y, int[][] map) {
		int x = 99;
        
		while (true) {
			x--; // 한 칸씩 아래로 이동
			if(x <= 0) break; // 맨 윗줄 도착 시 break
			
			// 오른쪽 확인, 이동
			if (y + 1 < 100 && map[x][y + 1] == 1) {
				while (y + 1 < 100 && map[x][y + 1] == 1) y++;
			}
			// 왼쪽 확인, 이동
			else {
				while ((y - 1 >= 0) && map[x][y - 1] == 1) y--;
			}
		}
		
		return y;
	}

    public static void main(String args[]) throws Exception {
    	Scanner sc = new Scanner(System.in);
        
    	for(int t = 1; t <= 10; t++) {
    		t = sc.nextInt();
    		int y = 0;
    		int map[][] = new int[100][100];
    		
    		for (int i = 0; i < 100; i++) {
    			for (int j = 0; j < 100; j++) {
    				map[i][j] = sc.nextInt();
    				// 도착점 위치 찾기 (도착점부터 거꾸로 탐색하기 위함)
    				if (map[i][j] == 2) y = j;
    			}
    		}
    		
    		System.out.printf("#%d %d\n", t, find(y, map));
    	}
    }
}
