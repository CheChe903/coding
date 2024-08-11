import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('i');
        set.add('e');
        set.add('o');
        set.add('u');

        StringBuilder sb = new StringBuilder();
        while(true)
        {
            String password = br.readLine();
             if(password.equals("end"))         
                 break;

            boolean firstCheck = false;
            boolean secondCheck = false;
            boolean thirdCheck= false;

            int continueConsonantsCount = 0;
            int continueVoewlCount =0;
            char lastCharacter = '\0';
            for(int i =0; i<password.length(); i++)
            {
                char c = password.charAt(i);
                if(set.contains(c))
                    firstCheck=true;

                if(set.contains(c))
                {
                    continueConsonantsCount++;
                    continueVoewlCount=0;
                }
                else
                {
                    continueVoewlCount++;
                    continueConsonantsCount=0;
                }

                if(continueConsonantsCount == 3 || continueVoewlCount == 3)
                {
                    secondCheck = true;
                    break;
                }

                if(lastCharacter == c)
                {
                    if(!(c=='e' || c=='o'))
                    {
                        thirdCheck = true;
                        break;
                    }
                }
                lastCharacter = c;
            }

            if(firstCheck && !secondCheck && !thirdCheck)
                sb.append("<" +password +"> is acceptable.\n");
            else
                sb.append("<" +password +"> is not acceptable.\n");

                
        }
        System.out.println(sb);
    }
}