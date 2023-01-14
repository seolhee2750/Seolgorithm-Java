package Implementation;

/*
 * BOJ #10699 오늘 날짜
 * https://www.acmicpc.net/problem/10699
 * 구현
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class BOJ_10699 {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(format.format(date));
	}
}
