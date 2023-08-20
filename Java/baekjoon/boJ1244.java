package com.syeon.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ1244 {

	static int count;
	static int[] arr; // 스위치 저장
	static int student;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		count = Integer.parseInt(br.readLine());
		arr = new int[count + 1];
		arr[0] = -1; // 0번째 스위치는 안쓸게요
		st = new StringTokenizer(br.readLine());
		// 스위치 입력
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 학생 입력
		student = Integer.parseInt(br.readLine());
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			// 남자
			if (gender == 1) {
				boys(num);
			}
			// 여자
			else if (gender == 2) {
				girls(num);
			}
		}

		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
		br.close();

	}

	// 자기가 받은 수의 배수라면 해당 스위치의 상태를 바꾼다.
	public static void boys(int num) {
		for (int i = num; i < arr.length; i++) {
			if (i % num == 0) {
				if (arr[i] == 1) {
					arr[i] = 0;
				} else
					arr[i] = 1;
			}
		}
	}

	// 자기가 받은 수와 같은 번호가 붙은 스위치(도 바꾸고)를 중심으로 좌우 대칭인데까지 상태 모두 바꾼다..
	public static void girls(int num) {
		// 해당 스위치 부터 변경해주기

		if (arr[num] == 0)
			arr[num] = 1;
		else if (arr[num] == 1)
			arr[num] = 0;

		int i = 1;
		while ((num - i) > 0 && (num + i) < arr.length && arr[num - i] == arr[num + i]) {
			if (arr[num - i] == 1) {
				arr[num - i] = 0;
				arr[num + i] = 0;
			} else {
				arr[num - i] = 1;
				arr[num + i] = 1;
			}

			i++;
		}
	}

}
