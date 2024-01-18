import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {

                Scanner sc = new Scanner(System.in);

                int a = sc.nextInt();
                int b = sc.nextInt();

                char [][]arr = new char[a][b];
                int answer = 9999;

                for(int i=0; i<a; i++)
                {
                        String s = sc.next();
                        for(int j =0; j<b; j++)
                        {

                                arr[i][j]= s.charAt(j);
                        }
                }

                for(int i =0; i<a-7; i++)
                {
                        for(int j =0; j<b-7; j++)
                        {
                                int count =0;
                                int count1 =0;
                                

                                        char next='W';
                                        
                                        for(int y= 0; y<8; y++)
                                        {
                                                char cur =next;
                                                
                                                for(int x= 0; x<8; x++)
                                                {
                                                        if(arr[y+i][x+j]!=next)
                                                        {
                                                                count++;
                                                        }

                                                        next = (next == 'B') ? 'W' : 'B';
                                                }

                                                if(cur=='W')
                                                        next='B';
                                                else
                                                        next='W';
                                        }

                                        next='B';
                                        for(int y= 0; y<8; y++)
                                        {
                                                char cur =next;
                                                for(int x= 0; x<8; x++)
                                                {
                                                        if(arr[y+i][x+j]!=next)
                                                        {
                                                                count1++;

  
                                                        }

                                                        next = (next == 'B') ? 'W' : 'B';
                                                }

                                                if(cur=='W')
                                                        next='B';
                                                else
                                                        next='W';
                                        }
                                
                                if(count>count1)
                                {
                                        count=count1;
                                }
                                
                                if(answer>count)
                                        answer=count;

                        }
                }
                System.out.println(answer);


        }


}