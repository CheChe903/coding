class Solution {
    public int solution(int k, int[][] dungeons) {
        /*
        ABC 이렇게 있다면
        ABC ACB BAC BCA CAB CBA 이렇게 던전을 갈 수 있다.

        모두 탐색을 하면서 visited의 최대값을 구하면 된다.

        무식하긴한데 방법이 이거말곤 떠오르지 않네요 ㅡ.ㅡ
        * */

        boolean[] visited = new boolean[dungeons.length];
            dfs(k, dungeons, visited);

        return max;

    }

    int max = Integer.MIN_VALUE;
    public void dfs(int k, int[][] dungeons, boolean[] visited) {
        int count = 0;
        for(int i = 0; i<visited.length; i++) {
            if(visited[i]) {
                count++;
            }
        }
        if(count > max) {
            max = count;
        }


        for(int i = 0; i<dungeons.length; i++) {
            if(!visited[i]) {
                if(dungeons[i][0] <= k) {
                    visited[i] = true;
                    k -= dungeons[i][1];
                    dfs(k, dungeons, visited);
                    k += dungeons[i][1];
                    visited[i] = false;
                }
            }
        }
    }
}