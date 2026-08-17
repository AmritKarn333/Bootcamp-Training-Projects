class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;

        // cnt[i] = number of prefixes having exactly i odd numbers
        int[] cnt = new int[n + 1];
        cnt[0] = 1;

        int oddCount = 0;
        int ans = 0;

        for (int num : nums) {
            // Add 1 if odd, 0 if even
            oddCount += num & 1;

            // Need an earlier prefix with (oddCount - k) odds
            if (oddCount >= k) {
                ans += cnt[oddCount - k];
            }

            cnt[oddCount]++;
        }

        return ans;
    }
}