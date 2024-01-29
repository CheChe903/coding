import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.*;
public class Main {


        public static void quickSort(int []arr, int start, int end, int find)
        {
                if(start<end)
                {
                        int pivot = partition(arr, start,end);
                        if(pivot ==find)
                        {
                                return;
                        }
                        else if(find<pivot)
                        {
                                quickSort(arr, start, pivot-1, find);
                        }
                        else
                        {
                                quickSort(arr, pivot+1, end, find);
                        }

                }
        }
        public static int partition(int[] arr, int start,int end)
        {
                if(start+1 == end)
                {
                        if(arr[start]> arr[end]) swap(arr,start,end);
                        return end;
                }

                int mid = (start+end) /2;
                swap(arr,start,mid);
                int pivot=arr[start];
                int i =start+1, j=end;
                while(i<=j)
                {
                        while(pivot < arr[j] && j>0)
                        {
                                j--;
                        }

                        while(pivot > arr[i] && i< arr.length-1)
                        {
                                i++;
                        }
                        if(i<=j)
                        {
                                swap(arr,i++,j--);
                        }
                }

                arr[start]= arr[j];
                arr[j]= pivot;
                return j;
        }

        public static void swap(int[] arr, int i, int j)
        {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]= temp;
        }
	public static void main(String[] args) throws IOException 
        {
  
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                StringTokenizer st =new StringTokenizer(br.readLine());

                int N= Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());

                int arr[] =new int[N];

                st =new StringTokenizer(br.readLine());
                for(int i =0; i<N; i++)
                {
                        arr[i]= Integer.parseInt(st.nextToken());
                }


                quickSort(arr,0,N-1, M-1);
 
                
                StringBuilder sb =new StringBuilder();
                sb.append(arr[M-1]);
                System.out.println(sb);
        }
}

