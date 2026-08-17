class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];

        // Frequency required from t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = 0;       // characters matched from t
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;

            // This occurrence is useful for satisfying t
            if (window[c] <= need[c]) {
                count++;
            }

            // Window contains all characters of t
            while (count == t.length()) {

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);

                if (window[leftChar] <= need[leftChar]) {
                    count--;
                }

                window[leftChar]--;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}