class Solution {
    StringBuilder sb = new StringBuilder();
	int[] xArr = new int[10];
	int[] yArr = new int[10];

	/*
	 * 입력으로 들어오는 문자열 X, Y의 숫자 하나 하나를 xArr, yArr 인덱스에 빈도수를 체크하는 메소드
	 */
	private void countFrequency(String X, String Y) {
		for (int i = 0; i < X.length(); i++) {
			int element = Integer.parseInt(String.valueOf(X.charAt(i)));
			xArr[element] += 1;
		}

		for (int i = 0; i < Y.length(); i++) {
			int element = Integer.parseInt(String.valueOf(Y.charAt(i)));
			yArr[element] += 1;
		}
	}

	/*
	 * xArr, yArr 순회하면서 둘 다 공통적으로 가지고 있는 원소를 StringBuilder에 append 하는 메소드
	 */
	private void findCommonCharacters() {
		for (int i = 0; i < 10; i++) {
			/* 배열 x, y의 원소 둘다 0이거나, 둘 중 하나라도 1이상인 경우는 공통으로 나타나는 정수가 아님 */
			while ((xArr[i] != 0 || yArr[i] != 0) && (xArr[i] != 0 || yArr[i] < 1) && (xArr[i] < 1 || yArr[i] != 0)) {
				sb.append(i);
				xArr[i] -= 1;
				yArr[i] -= 1;
			}
		}
	}

	/*
	 * StringBuilder의 결과를 출력하는 메소드
	 */
	private String printAnswer() {
		String answer = sb.reverse().toString();

		if (answer.equals("")) {
			return "-1";
		}
		if (answer.startsWith("0")) {
			return "0";
		}

		return answer;
	}

	public String solution(String X, String Y) {
		countFrequency(X, Y);
		findCommonCharacters();
		return printAnswer();
	}
}
