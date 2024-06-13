import java.util.*;

class Solution {

    static Map<String, PriorityQueue<String>> flightMap;
    static LinkedList<String> result;

    public String[] solution(String[][] tickets) {
        flightMap = new HashMap<>();
        result = new LinkedList<>();

        for (String[] ticket : tickets) 
        {
            flightMap.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        dfs("ICN");

        return result.toArray(new String[result.size()]);
    }

    public void dfs(String airport) 
    {
        PriorityQueue<String> destinations = flightMap.get(airport);
        while (destinations != null && !destinations.isEmpty()) 
        {
            dfs(destinations.poll());
        }
        result.addFirst(airport);
    }

}