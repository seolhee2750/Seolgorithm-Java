package D3;

import java.util.Scanner;

public class SWEA_1208 {
	
	static int max = 0;
	static int min = 0;
	static int dumpNum = 0;
	
	public static int dump(int[] nums) {
		while(true) {
			if(nums[max] - nums[min] <= 1 || dumpNum < 0) {
				return nums[max] - nums[min];
			}
			
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] > nums[max]) max = i;
				if(nums[i] < nums[min]) min = i;
			}
			
			nums[max]--;
			nums[min]++;
			dumpNum--;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			dumpNum = sc.nextInt();
			int[] nums = new int[100];
			
			for(int i = 0; i < nums.length; i++) {
				nums[i] = sc.nextInt();
				if(nums[i] > nums[max]) max = i;
				if(nums[i] < nums[min]) min = i;
			}
					
			System.out.printf("#%d %d\n", t+1, dump(nums) + 2);
		}
	}

}
