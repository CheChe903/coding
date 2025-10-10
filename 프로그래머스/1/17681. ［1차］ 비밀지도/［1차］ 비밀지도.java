class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        int arr[][] = new int[n][n];
        
        for(int i =0; i<n; i++) {
            String binary1 = addZero(Integer.toBinaryString(arr1[i]), n);
            String binary2 = addZero(Integer.toBinaryString(arr2[i]), n);
            String answer2 = "";
            for(int j =0; j<n; j++) {
                if(binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
                    answer2 = answer2 +"#";
                }
                else {
                    answer2 = answer2 +" ";
                }
            }
            answer[i] = answer2;
        }
        return answer;
    }
    
    public String addZero(String str, int n) {
        while(str.length() != n) {
            str = "0"+ str;
        }
        return str;
    }
}