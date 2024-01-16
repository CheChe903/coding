import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a= sc.nextInt();
        int b = sc.nextInt();


        if(b>=45)
        {
            
            System.out.printf("%d %d", a, b-45);
        }

        else
        {
            System.out.printf("%d %d", a-1>=0?a-1:23,b+15);
        }
            

        


            
	}
}