package com.ssafy.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class boJ10828 {
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
	    //N입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			//명령입력받기
			String s = st.nextToken();
			
			//push
			if (s.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			//pop
			else if (s.equals("pop")) {
				if(stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
			}
			//size
			else if (s.equals("size")) {
				System.out.println(stack.size());
			}
			//empty
			else if (s.equals("empty")) {
				if(stack.empty())
					System.out.println(1);
				else
					System.out.println(0);
			}
			//top
			else if (s.equals("top")) {
				if(stack.empty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
			}
			
			
			
			
		}	
	}
}
