package implementationandsimulation;

import java.awt.Point;
import java.io.*;
import java.util.*;

// char temp = Character.forDigit(정수, 10); // int to char (10진수를 char로 변경)
// char[] temp = str.toCharArray(); // 문자열을 문자 배열로 변경

public class Quiz1063 {

	static final int size = 7;
	static Point kingPoint = new Point();
	static Point stonePoint = new Point();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		kingPoint = strPosTo2DPos(st.nextToken());
		stonePoint = strPosTo2DPos(st.nextToken());

		int moveCnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < moveCnt; i++) {
			movePos(br.readLine());
		}

		printPos(kingPoint);
		printPos(stonePoint);

	}

	private static Point strPosTo2DPos(String strPos) {
		final int xPos = strPos.charAt(0) - 'A';
		final int yPos = strPos.charAt(1) - '1';
		return new Point(xPos, yPos);
	}

	private static void printPos(Point commonPoint) {
		StringBuilder sb = new StringBuilder();

		sb.append((char) (commonPoint.x + 'A'));
		sb.append((char) (commonPoint.y + '1'));

		System.out.println(sb);
	}

	private static void movePos(String howToMove) {

		char[] pos = howToMove.toCharArray();

		Point pointDiff = new Point();
		
		for (int i = 0; i < pos.length; i++) {
			switch (pos[i]) {
			case 'R':
				pointDiff.x = 1;
				break;
			case 'L':
				pointDiff.x = -1;
				break;
			case 'B':
				pointDiff.y = -1;
				break;
			case 'T':
				pointDiff.y = 1;
				break;
			default:
				break;
			}

		}

		if (isInsideTheBoard(kingPoint, pointDiff)) {
			if ((stonePoint.x == (kingPoint.x + pointDiff.x)) && (stonePoint.y == (kingPoint.y + pointDiff.y))) {
				if (isInsideTheBoard(stonePoint, pointDiff)) {
					kingPoint.setLocation((kingPoint.x + pointDiff.x), (kingPoint.y + pointDiff.y));
					stonePoint.setLocation((stonePoint.x + pointDiff.x), (stonePoint.y + pointDiff.y));
				}
			} else {
				kingPoint.setLocation((kingPoint.x + pointDiff.x), (kingPoint.y + pointDiff.y));
			}

		}

	}

	private static boolean isInsideTheBoard(Point commonPoint, Point pointDiff) {

		boolean isInside = true;

		if ((commonPoint.x + pointDiff.x) > size || (commonPoint.x + pointDiff.x) < 0) {
			isInside = false;
		} else if ((commonPoint.y + pointDiff.y) > size || (commonPoint.y + pointDiff.y) < 0) {
			isInside = false;
		}

		return isInside;
	}

}
