class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] result = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) 
        {
            String target = targets[i];           
            for (char c : target.toCharArray()) 
            {
                int minIdx = Integer.MAX_VALUE;
                
                
                for (String key : keymap) 
                {
                    int idx = key.indexOf(c);
                    if (idx > -1 && minIdx > idx) 
                    {
                        minIdx = idx;
                    }
                }
                if (minIdx < Integer.MAX_VALUE && result[i] != -1) 
                {
                    result[i] += minIdx + 1;
                } 
                else 
                {
                    result[i] = -1;
                }
            }
        }
        
        return result;
    }
}