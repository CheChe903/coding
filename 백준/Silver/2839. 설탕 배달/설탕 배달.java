import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                int a = sc.nextInt();
                int answer=9999;

                for(int i =0; i<a/5+1; i++)
                {
                        int cur =0;
                        int k =a;
                        int three =0;
                        int five =0;
                        
                        if(k>=5)
                        {
                                k = k -i*5;
                                cur +=i;
                                five =cur;

                        }
                        if(k%3==0)
                        {
                                cur+=k/3;
                                three=k/3;
                        }

                        if(five*5 + three*3 == a)
                        {
                                if(answer>cur)
                                {
                                        answer = cur;
                                        
                                }
                        }
                }
                if(answer==9999)

                {
                        answer=-1;
                }
                System.out.println(answer);
        }


}