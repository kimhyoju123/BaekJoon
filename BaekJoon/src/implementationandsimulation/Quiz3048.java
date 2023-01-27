package implementationandsimulation;

import java.io.*;
import java.util.*;

public class Quiz3048 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n1 = Integer.parseInt(st.nextToken()); // 첫 번째 그룹의 개미의 수
		int n2 = Integer.parseInt(st.nextToken()); // 두 번째 그룹의 개미의 수

		String group1 = br.readLine();

		String group2 = br.readLine();

		int time = Integer.parseInt(br.readLine());

		List<Group> arrList = new ArrayList<Group>();
		
		for (int i = n1 - 1; i >= 0; i--) {
			arrList.add(new Group(group1.charAt(i), 1));
		}
		
		for (int i = 0; i < n2; i++) {
			arrList.add(new Group(group2.charAt(i), 2));
		}
		
		while (time-- > 0) {
			for (int i = 0; i < arrList.size() - 1; i++) {
				Group current = arrList.get(i);
				Group next = arrList.get(i + 1);

				if (current.groupNum != 2 && current.groupNum != next.groupNum) {
					arrList.set(i, next);
					arrList.set(i + 1, current);
					i++;
				}
			}
		}

		for (int i = 0; i < arrList.size(); i++) {
			System.out.print(arrList.get(i).member);
		}

	}

	public static class Group {
		char member;
		int groupNum;

		public Group(char member, int groupNum) {
			this.member = member;
			this.groupNum = groupNum;
		}
	}

}
