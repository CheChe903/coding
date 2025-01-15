import java.io.*;
import java.util.*;

class Player {
    int level;
    String name;

    public Player(int level, String name) {
        this.level =level;
        this.name = name;
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st  = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Player>> list = new ArrayList<>();

        for(int i =0; i<p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Player player = new Player(level, name);

            boolean check = true;
            if(!list.isEmpty()) {
                for(List<Player> currentList : list) {
                    Player firstPlayer = currentList.get(0);

                    if(Math.abs(level - firstPlayer.getLevel()) <=10 && currentList.size() < m) {
                        currentList.add(player);
                        check =false;
                        break;
                    }
                }
            }
            if(check || list.isEmpty()) {
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(player);
            }
        }


        for(List<Player> currentList : list) {
            Collections.sort(currentList, new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    return p1.getName().compareTo(p2.getName());
                }
            });
            if(currentList.size() == m ) {
                System.out.println("Started!");
            }
            else {
                System.out.println("Waiting!");
            }

            for(Player player : currentList) {
                System.out.println(player.level +" " +player.name);
            }
        }

    }

}