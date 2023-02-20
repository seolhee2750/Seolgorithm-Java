package Strings;

/*
 * BOJ #5635 생일
 * https://www.acmicpc.net/problem/5635
 * 문자열, 구현
 */

import java.io.*;
import java.util.*;

public class BOJ_5635 {
	
	static class Student implements Comparable<Student> {
		String name;
		int day;
		int month;
		int year;
		
		public Student(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
		
		@Override
		public int compareTo(Student o) {
			if(this.year != o.year) {
				return this.year - o.year;
			} else {
				if(this.month != o.month) {
					return this.month - o.month;
				} else {
					return this.day - o.day;
				}
			}
		}
	}

	static int n;
	static Student[] students;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(in.readLine());
		students = new Student[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			students[i] = new Student(st.nextToken(), 
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(students);
		System.out.println(students[n-1].name + "\n" + students[0].name);
	}
}
