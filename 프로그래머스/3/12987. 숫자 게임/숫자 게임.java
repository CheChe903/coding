import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(B);
        Arrays.sort(A);
        int index=0;
        for(int i =0; i<A.length; i++)
        {
            if(A[index]<B[i])
                index++;
        }
        return index;
    }
}