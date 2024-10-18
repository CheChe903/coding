import java.util.*;
import java.io.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
        int answer = getPascal(n,k);
        
        System.out.println(answer);
	}

    public static int getPascal(int n, int k) {

        if(n==1  || (k==1) || (n==k))
            return 1;

        return getPascal(n-1, k-1) + getPascal(n-1, k);
    }

}