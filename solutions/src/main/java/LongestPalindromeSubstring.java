public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        String str = "";
        int minLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 > minLength) {
                    minLength = right - left + 1;
                    str = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 > minLength) {
                    minLength = right - left + 1;
                    str = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }

        return str;
    }

    public static void main(String[] args) {

        LongestPalindromeSubstring palindrome = new LongestPalindromeSubstring();
        System.out.println("Longest Palindromic Substring " + palindrome.longestPalindrome("cbbd"));
    }
}
