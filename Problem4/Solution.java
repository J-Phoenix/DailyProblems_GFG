import java.util.*;

class Solution {
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) return "";

        // frequency maps
        int[] need = new int[128];
        int[] window = new int[128];

        for (char c : p.toCharArray()) {
            need[c]++;
        }

        int required = p.length(); // total chars we must match
        int left = 0, right = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;

            if (need[c] > 0 && window[c] <= need[c]) {
                formed++; // matched one needed char
            }

            // when we matched all chars of p
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // try shrinking from left
                char leftChar = s.charAt(left);
                if (need[leftChar] > 0 && window[leftChar] <= need[leftChar]) {
                    formed--; // removing a required char
                }
                window[leftChar]--;
                left++;
            }

            right++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLen);
    }
}
