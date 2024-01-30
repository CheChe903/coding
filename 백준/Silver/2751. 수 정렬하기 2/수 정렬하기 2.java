import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {

        public static int[] arr, tmp;
        public static long result;
        private static void MergeSort(int s, int e)
        {
                if(e-s <1)
                {
                        return;
                }
                int m = s+(e-s)/2;

                MergeSort(s, m);
                MergeSort(m+1, e);

                for(int i=s; i<=e; i++)
                {
                        tmp[i] = arr[i];
                }
                int k =s;
                int index1 = s;
                int index2 = m+1;
                while(index1 <=m && index2 <=e)
                {
                        if(tmp[index1] > tmp[index2])
                        {
                                arr[k] = tmp[index2];
                                k++;
                                index2++;
                        }
                        else
                        {
                                arr[k] = tmp[index1];
                                k++;
                                index1++;
                        }
                }

                while(index1 <=m)
                {
                        arr[k] = tmp[index1];
                        index1++;
                        k++;
                }

                while(index2 <=e)
                {
                        arr[k] = tmp[index2];
                        index2++;
                        k++;
                }
        }

	public static void main(String[] args) throws IOException 
        {
  
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                StringTokenizer st =new StringTokenizer(br.readLine());

                int N= Integer.parseInt(st.nextToken());

                arr =new int[N];
                tmp = new int[N];
                for(int i =0; i<N; i++)
                {
                        arr[i]= Integer.parseInt(br.readLine());
                }

 
                MergeSort(0,N-1);
                
                StringBuilder sb =new StringBuilder();
                for(int i =0; i<N; i++)
                {
                        sb.append(arr[i]).append("\n");
                }
                System.out.println(sb);
        }
}

