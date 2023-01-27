package implementationandsimulation;

import java.io.*;
import java.util.*;

public class Quiz8979 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		String searchContry = st.nextToken();

		List<MedalInfo> arrList = new ArrayList<MedalInfo>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			MedalInfo contry = new MedalInfo(st.nextToken(), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		
			arrList.add(contry);
		}

		Collections.sort(arrList); // 정렬하려는 리스트의 타입인 클래스가 Compatable을 상속하고 있어야 사용 가능
		
		arrList.get(0).rank = 1;
		
		int resultIndex = 0;
		
		for (int i = 1; i < arrList.size(); i++) {
			MedalInfo now = arrList.get(i);
			MedalInfo before = arrList.get(i - 1);

			if (now.gold == before.gold && now.silver == before.silver && now.bronze == before.bronze) {
				now.rank = before.rank;
			} else {
				now.rank = i + 1;
			}
			
			// 등수를 알고 싶은 국가의 인덱스를 resultIndex 변수에 담음
			if (now.contryName.equals(searchContry)) {
				resultIndex = i;
			}

		}
		
		System.out.println(arrList.get(resultIndex).rank);

	}

	public static class MedalInfo implements Comparable<MedalInfo> {
		String contryName;
		int gold;
		int silver;
		int bronze;
		int rank;

		public MedalInfo(String contryName, int gold, int silver, int bronze, int rank) {
			this.contryName = contryName;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = rank;
		}

		@Override
		public int compareTo(MedalInfo medalInfo) {
			// 내림차순 정렬
			if (this.gold == medalInfo.gold) {
				if (this.silver == medalInfo.silver) {
					return medalInfo.bronze - this.bronze;
				}

				return medalInfo.silver - this.silver;
			}

			return medalInfo.gold - this.gold;
		}

	}

}
