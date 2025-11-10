class Solution {

    public int solution(int n, int k) {
        String currentN = change(n, k);
        int answer = 0;

        String[] parts = currentN.split("0");
        for (String part : parts) {
            if (part.isEmpty()) continue;
            long num = Long.parseLong(part);
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    static String change(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    static boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
