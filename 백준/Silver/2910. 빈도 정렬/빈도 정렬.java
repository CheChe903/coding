import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, int[]> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        int index = 1;
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            int[] curarr;
            if (map.containsKey(cur)) {
                curarr = map.get(cur);
                curarr[0]++;
            } else {
                curarr = new int[2];
                curarr[0] = 1;
                curarr[1] = index;
                index++;
            }
            map.put(cur, curarr);
        }
        List<Map.Entry<Integer, int[]>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort(new Comparator<Map.Entry<Integer, int[]>>() {
            @Override
            public int compare(Map.Entry<Integer, int[]> o1, Map.Entry<Integer, int[]> o2) {
                if (o2.getValue()[0] != o1.getValue()[0]) {
                    return Integer.compare(o2.getValue()[0], o1.getValue()[0]);
                }
                return Integer.compare(o1.getValue()[1], o2.getValue()[1]);
            }
        });

        for (Map.Entry<Integer, int[]> entry : entryList) {
            int number = entry.getKey();
            int count = entry.getValue()[0];
            for (int i = 0; i < count; i++) {
                System.out.print(number + " ");
            }
        }
    }
}
