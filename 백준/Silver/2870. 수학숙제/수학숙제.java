import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        ArrayList<String> list = new ArrayList<>();
        for(int i =0; i<N; i++) {
            String str = br.readLine();
            
            String curNum = "";
            boolean check =true;
            boolean check2 = false;
            for(int j =0; j<str.length(); j++) {
                
                int cur = str.charAt(j) -'0';
                if(cur >=0 && cur <=9) {

                    if(curNum ==""&& cur ==0) {
                        check2=true;
                        continue;
                    }
                    curNum += cur;
                    check=false;
                }
                else if( curNum !="") {
                    list.add(curNum);
                    curNum ="";
                    check2=false;
                }
                else if(curNum == "" && check2) {
                    list.add("0");
                    check2=false;
                }
            }

            if(curNum != "") {
                list.add(curNum);
                curNum ="";
                check2=false;
            }
            else if(curNum == "" && check2) {
                list.add("0");
                check2=false;
            }

        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                else
                    return s1.length() - s2.length();
            }
        });
        for(String num : list) {
            System.out.println(num);
        }
    }
}
