import java.io.*;
import java.util.*;

public class Main {
    static int maxHeight, maxWidth, widthIndex, heightIndex, length[];
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringTokenizer st;

        maxHeight = Integer.MIN_VALUE;
        maxWidth = Integer.MIN_VALUE;
        widthIndex = 0;
        heightIndex = 0;
        length= new int[6];

        for(int i = 0; i<6; i++) {
            st= new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());

            length[i] = Integer.parseInt(st.nextToken());

            if(dir == 1 || dir ==2) {
                if(maxWidth < length[i]) {
                    maxWidth = length[i];
                    widthIndex = i;
                }
            }

            else if(dir ==3 || dir ==4)  {
                if(maxHeight < length[i]) {
                    maxHeight = length[i];
                    heightIndex = i;
                }
            }
        }

        int tempWidth = lengthCal(heightIndex);
        int tempHeight = lengthCal(widthIndex);

        int result = ((maxHeight * maxWidth) -  (tempHeight * tempWidth)) *K;

        System.out.println(result);
    }


    static int lengthCal(int index ) {

        int result = 0;
        if (index ==0 ) {
            result = Math.abs(length[index+1] - length[5]);
        }
        else if(index ==5) {
            result = Math.abs(length[index-1] - length[0]);
        }

        else {
            result = Math.abs(length[index+1] - length[index-1]);
        }

        return result;
    }
}
