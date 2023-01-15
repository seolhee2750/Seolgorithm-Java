package Implementation;

/*
 * BOJ #15659 연산자 끼워넣기 (3)
 * https://www.acmicpc.net/problem/15659
 * 구현
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15659 {

    static int n;
    static int[] nums;
    static int[] cals = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(in.readLine());
        nums = new int[n];
        
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 4; i++) {
        	cals[i] = Integer.parseInt(st.nextToken());
        }
        
        calculation(1, 0, nums[0]);
        System.out.println(max + "\n" + min);
    }

    private static void calculation(int idx, int sum, int tmp) {
        if (idx == n) {
            max = Math.max(max, sum + tmp);
            min = Math.min(min, sum + tmp);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (cals[i] == 0) continue;
            cals[i]--;
            switch(i) {
            	case 0: 
            		calculation(idx+1, sum+tmp, nums[idx]);
            		break;
            	case 1:
            		calculation(idx+1, sum+tmp, -nums[idx]);
            		break;
            	case 2:
            		calculation(idx+1, sum, tmp*nums[idx]);
            		break;
            	case 3:
            		calculation(idx+1, sum, tmp/nums[idx]);
            		break;
            }
            cals[i]++;
        }
    }
}