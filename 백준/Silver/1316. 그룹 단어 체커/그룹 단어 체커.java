import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                int n = sc.nextInt();
                int answer= 0;
                
                for(int i=0; i<n; i++)
                {
                        int cur =0;
                        String s = sc.next();
                        for(int j =0; j<s.length(); j++)
                        {
                                int first=0;
                                for(int k =j; k<s.length(); k++)
                                {
                                        if((s.charAt(j) != s.charAt(k)) && first ==0)
                                        {
                                                first=1;
                                        }
                                        if((s.charAt(j) == s.charAt(k))&& first==1)
                                        {
                                                cur=1;
                                                break;
                                        }
                                }

                        }

                        if(cur==0)
                        {
                                answer++;
                        
                        }


                }
                System.out.println(answer);
        }

}