package implementationandsimulation;

import java.io.*;
import java.util.*;

public class Quiz2980 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 신호등 개수
		int length = Integer.parseInt(st.nextToken()); // 거리

		int time = 0;
		int position = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int drive = Integer.parseInt(st.nextToken());
			int redSign = Integer.parseInt(st.nextToken());
			int greenSign = Integer.parseInt(st.nextToken());
			
			time += drive - position;
			position = drive;
			
			int gap = time % (redSign + greenSign);
			
			if (gap < redSign) {
				time += redSign - gap;
			}
			
		}
		
		time += length - position;
		
		System.out.println(time);

	}

}
