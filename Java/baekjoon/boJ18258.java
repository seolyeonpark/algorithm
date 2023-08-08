package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boJ18258 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		 //N입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int temp = 0;
		
		
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String s = st.nextToken();
			
			//push
			if (s.equals("push")) {
				
				temp = Integer.parseInt(st.nextToken());
				queue.offer(temp);
			}
			//pop - poll(): 앞에 있는 요소 반환하고 삭제 처리 
			else if (s.equals("pop")) {
				if(queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.poll()).append("\n");
			
			}
			//size
			else if (s.equals("size")) {
				sb.append(queue.size()).append("\n");
			}
			//empty
			else if (s.equals("empty")) {
				if(queue.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
			//front
			else if (s.equals("front")) {
				if(queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(queue.peek()).append("\n");
			}
			//back
			else if (s.equals("back")) {
				if(queue.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(temp).append("\n");
			}
			
		}
		
		
		System.out.println(sb);

	}

}
