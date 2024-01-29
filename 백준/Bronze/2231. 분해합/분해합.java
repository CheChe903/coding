import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                int n = sc.nextInt();

                int answer =0;
                for(int i =0; i<n; i++)
                {
                        int sum =0;
                        int cur =i;
                        while(cur>0)
                        {
                                sum+=cur%10;
                                cur/=10;
                        }

                        if(i+sum ==n)
                        {
                                answer=i;
                                break;
                        }
        
                }

                System.out.println(answer);
        }


}