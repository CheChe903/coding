class Solution {
    public int solution(int n) {
        int answer = 0;
        int myn=n;
        int count=cnt(myn);
        int count2=0;
        while(count2!=count)
        {
            myn+=1;
            count2=cnt(myn);
        }
        return myn;
    }
    
    static int cnt(int n)
    {
        int myn=n;
        int count=0;
        while(myn>1)
        {
            if(myn%2!=0)
                count++;
            myn=myn/2;

        }
        if(myn==1)
            return count+1;
        else
            return count;
    }
}