import java.util.*;
import java.io.*;

class Solution {
    long answer = 0;
    public long solution(String expression) {
        
        List<Long> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : expression.toCharArray()) {
            if(ch == '+' || ch == '-' || ch == '*') {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                ops.add(ch);
            }
            else {
                sb.append(ch);
            }
        }
        
        nums.add(Long.parseLong(sb.toString()));
        
        Set<Character> set = new LinkedHashSet<>(ops);
        char[] opKinds = new char[set.size()];
        int idx = 0;
        for(char c : set) opKinds[idx++] = c;
        
        boolean used[] = new boolean[opKinds.length];
        char order[] = new char[opKinds.length];
        
        sol(0, nums, ops, order, opKinds, used);
        return answer;
    }
    
    public void sol(int depth, List<Long> baseNums, List<Character> baseOps, char order[],
                    char[] opKinds, boolean [] used) {
        if(depth == opKinds.length) {
            
            List<Long> nums = new ArrayList<>(baseNums);
            List<Character> ops = new ArrayList<>(baseOps);
            
            for(char target : order) {
                for(int i =0; i<ops.size(); ) {
                    if(ops.get(i) == target) {
                        long a = nums.get(i);
                        long b = nums.get(i+1);
                        long r = apply(a,b, target);
                        
                        nums.set(i,r);
                        nums.remove(i+1);
                        ops.remove(i);
                    }
                    else {
                        i++;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(nums.get(0)));
        }
        
        for(int i =0; i<opKinds.length; i++) {
            if(!used[i]) {
                used[i] = true;
                order[depth] = opKinds[i];
                sol(depth+1, baseNums, baseOps, order, opKinds, used);
                used[i] = false;
            }   
        }
    }
    public long apply(long a, long b, Character target) {
        if(target == '+') {
            return a+b;
        }
        else if(target =='-') {
            return a-b;
        }
        else {
            return a*b;
        }
    }
}