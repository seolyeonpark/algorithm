package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boJ20436 {
	// 앗 처음에는 string hand를 만들어서 클래스에 추가해주려고 했는데 잘 안되네요
	private static class hand {
		int x;
		int y;

		public hand(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws Exception {

		// hashmap 키값으로 조회해서 검사하기
		Map<Character, hand> con = new HashMap<>();
		Map<Character, hand> vo = new HashMap<>();
		// 넣는 작업
		// 자음
		con.put('q', new hand(0, 0));
		con.put('w', new hand(0, 1));
		con.put('e', new hand(0, 2));
		con.put('r', new hand(0, 3));
		con.put('t', new hand(0, 4));
		con.put('a', new hand(1, 0));
		con.put('s', new hand(1, 1));
		con.put('d', new hand(1, 2));
		con.put('f', new hand(1, 3));
		con.put('g', new hand(1, 4));
		con.put('z', new hand(2, 0));
		con.put('x', new hand(2, 1));
		con.put('c', new hand(2, 2));
		con.put('v', new hand(2, 3));
		// 모음
		vo.put('y', new hand(0, 5));
		vo.put('u', new hand(0, 6));
		vo.put('i', new hand(0, 7));
		vo.put('o', new hand(0, 8));
		vo.put('p', new hand(0, 9));
		vo.put('h', new hand(1, 5));
		vo.put('j', new hand(1, 6));
		vo.put('k', new hand(1, 7));
		vo.put('l', new hand(1, 8));
		vo.put('b', new hand(2, 4));
		vo.put('n', new hand(2, 5));
		vo.put('m', new hand(2, 6));

		// 로직 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		String leftone = st.nextToken();
		String rightone = st.nextToken();
		hand L, R;
		
		
		
		// 널포인터 난 이유는....string을 character에 넣어서 찾아주려고 해서 그런 모양..;;
		L = con.get(leftone.charAt(0));
		R = vo.get(rightone.charAt(0));
		char find;

		String input = br.readLine();
		int time = 0;
		for (int i = 0; i < input.length(); i++) {
			find = input.charAt(i);
			// 포함 되어 있다면
			if (con.containsKey(find)) {
				hand disL = con.get(find);
				// 택시거리 공식( 절댓값 ) 에 시간 1초 더해주기
				
				time += Math.abs(disL.x - L.x) + Math.abs(disL.y - L.y) + 1;
				// L값 변경 시켜주기 !!!!
				L = disL;
			} else {
				hand disR = vo.get(find);

				time += Math.abs(disR.x - R.x) + Math.abs(disR.y - R.y) + 1;
				R = disR;
			}
		}

		System.out.println(time);

	}
}