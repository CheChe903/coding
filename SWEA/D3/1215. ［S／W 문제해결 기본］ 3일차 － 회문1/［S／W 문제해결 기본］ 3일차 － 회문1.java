/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int L = Integer.parseInt(br.readLine());
            char [][] arr = new char[9][9];
            
            int answer =0;
            for(int i =1; i<=8; i++) {
                String input = br.readLine();
            	for(int j =1; j<=8; j++) {
                	arr[i][j] = input.charAt(j-1);
                }
            }
            for(int i = 1; i <= 8; i++) {
                for(int j = 1; j <= 8-L+1; j++) {
                    String check = "";
                    for(int k = 0; k < L; k++) {
                        check += arr[i][j+k];
                    }
                    if(func(check)) {
                        answer++;
                    }
                }
            }
            
            // 세로 검사
            for(int j = 1; j <= 8; j++) {
                for(int i = 1; i <= 8-L+1; i++) {
                    String check = "";
                    for(int k = 0; k < L; k++) {
                        check += arr[i+k][j];
                    }
                    if(func(check)) {
                        answer++;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.println(sb);
	}
    
    static boolean func(String input) {
    
        int start = 0;
        int end = input.length() -1;
        
        while(start<=end) {
        	if(input.charAt(start) != input.charAt(end)) {
            	return false;
            }
         	start++;
            end--;
        }
        return true;

    }
}