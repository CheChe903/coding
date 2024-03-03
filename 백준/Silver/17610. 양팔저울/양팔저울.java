import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Main {
 

	static int k,sum,ans;
	static int []v = new int[14];
	static boolean []a = new boolean[3000000];
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		int sum =0;
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i =0; i<k; i++)
		{
			v[i] = Integer.parseInt(st.nextToken());
			sum+=v[i];
			
		}
		
		dfs(0,0);
		System.out.println(sum-ans);

 
	}
	public static void dfs(int n, int cur)
	{
		if(cur >=1)
		{
			if(!a[cur]) 
				ans++;
			a[cur]=true;
		}

		if(n ==k) return;
		dfs(n+1, cur+v[n]);
		dfs(n+1, cur-v[n]);
		dfs(n+1,cur);
	}

}