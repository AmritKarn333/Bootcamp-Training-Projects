class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            freq[s.charAt(right) - 'A']++;

            // Maximum frequency in current window
            maxFreq = Math.max(
                maxFreq,
                freq[s.charAt(right) - 'A']
            );

            // Characters that need replacement
            int windowSize = right - left + 1;

            while (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                windowSize = right - left + 1;
            }

            ans = Math.max(ans, windowSize);
        }

        return ans;
    }
}