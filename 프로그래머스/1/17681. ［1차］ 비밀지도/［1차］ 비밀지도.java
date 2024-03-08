import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        
        for(int i=0; i<n; i++)
        {
            String str ="";
            String str1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            // 두 번째 배열의 이진 문자열 생성
            String str2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');

            for (int j =0; j<n; j++)
            {
                if(str1.charAt(j)=='1' || str2.charAt(j)=='1')
                {
                    str+="#";
                }
                else
                {
                    str+=" ";
                }
            }
            answer[i]=str;
        }
        return answer;

    }
}