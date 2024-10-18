import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();

        String inputList[] = input.split(":");

        int n = Integer.parseInt(inputList[0]);
        int m = Integer.parseInt(inputList[1]);

        int mygcd = gcd(n,m);
        System.out.println(n/mygcd+":"+m/mygcd);

    }   

    public static int gcd(int n, int m ) {

        while(!(m==0)) {
            int temp = m;
            m = n%m;
            n=temp;
        }

        return n;
    }

}