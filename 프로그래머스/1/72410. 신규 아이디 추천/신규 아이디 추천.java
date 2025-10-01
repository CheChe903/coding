class Solution {
    public String solution(String new_id) {
        String answer = first(new_id);
        return answer;

    }
    
    public String first(String input) {
        return second(input.toLowerCase());
    }
    
    public String second(String input) {
        input = input.replaceAll("[^a-z0-9-_.]", "");
        return third(input);
    }
    
    public String third(String input) {
        input = input.replaceAll("\\.+", ".");
        return fourth(input);
    }
    
    public String fourth(String input) {
        input = input.replaceAll("^\\.|\\.$", "");
        return fifth(input);
    }
    
    public String fifth(String input) {
        if(input.length() ==0) {
            return sixth("a");
        }
        return sixth(input);
    }
    
    public String sixth(String input) {
        if(input.length() >=16) {
         input = input.substring(0,15);
        input = input.replaceAll("\\.$", "");  
        }
        return seventh(input);
    }
    
    public String seventh(String input) {
        if(input.length() <=3) {
            char last = input.charAt(input.length() - 1);
            while (input.length() < 3) {
                input += last;
            }
        }
        return input;
        
    }
    
    
}