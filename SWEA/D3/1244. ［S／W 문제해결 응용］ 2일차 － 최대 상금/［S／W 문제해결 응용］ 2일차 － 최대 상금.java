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
    static int N,max;
    static char num[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            st = new StringTokenizer(br.readLine());
            num = st.nextToken().toCharArray();
			N = Integer.parseInt(st.nextToken());
            max =0;
            dfs(0,0);
            System.out.println("#"+test_case+" " +max);
		}
	}
    static void dfs(int start, int count) {
        if(count == N) {
            max = Math.max(max, Integer.parseInt(new String(num)));
            return;
        }
        for(int i =start; i<num.length; i++) {
        	for(int j = i+1; j<num.length; j++) {
                swap(i,j);
                dfs(i,count+1);
                swap(i,j);
            }
        }
    }
    static void swap(int idx1, int idx2) {
    	char temp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = temp;
   
    }
}