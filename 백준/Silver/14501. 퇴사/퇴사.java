import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                int a = sc.nextInt();

                int[] needday = new int[a+15];

                int[] pay= new int[a+15];

                int[] max = new int[a+15];

                for(int i =1; i<=a; i++)
                {
                        needday[i] = sc.nextInt();
                        pay[i] = sc.nextInt();
                        max[i]=0;
                }
                if(needday[a]==1)
                {
                        max[a]=pay[a];
                }

                for(int i=a-1; i>=1; i--)
                {
                    int next = i + needday[i];
                    
                    if(next > a  +1)
                    {
                        max[i] = max[i+1];
                    }
                    else
                    {
                        max[i]= Math.max(max[i+1], max[i+needday[i]]+pay[i]);

                    }
                        
                }

                System.out.println(max[1]);
        }


}