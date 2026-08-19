class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];

        for (char c : t.toCharArray())
            count[c]++;

        int left = 0, start = 0;
        int need = t.length();
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)] > 0)
                need--;

            count[s.charAt(right)]--;

            while (need == 0) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                count[s.charAt(left)]++;

                if (count[s.charAt(left)] > 0)
                    need++;

                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}