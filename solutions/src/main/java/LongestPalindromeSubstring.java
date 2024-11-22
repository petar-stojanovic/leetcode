public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {

            String oddPalindrome = expandFromCenter(s, i, i);
            String evenPalindrome = expandFromCenter(s, i, i + 1);

            if (longest.length() < oddPalindrome.length()) {
                longest = oddPalindrome;
            }

            if (longest.length() < evenPalindrome.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {

        LongestPalindromeSubstring palindrome = new LongestPalindromeSubstring();
        System.out.println("Longest Palindromic Substring " + palindrome.longestPalindrome("cbbd"));
        System.out.println("Longest Palindromic Substring " + palindrome.longestPalindrome("anavolimilovana"));
        System.out.println("Longest Palindromic Substring " + palindrome.longestPalindrome("babad"));
        System.out.println("Longest Palindromic Substring " + palindrome.longestPalindrome("bb"));
    }
}
