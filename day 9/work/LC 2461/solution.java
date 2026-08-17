class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        long sum = 0;
        long ans = 0;

        // Build the first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        // If first window has all distinct elements
        if (freq.size() == k) {
            ans = sum;
        }

        // Slide the window
        for (int i = k; i < nums.length; i++) {

            // Add new element
            sum += nums[i];
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            // Remove old element
            int old = nums[i - k];
            sum -= old;

            freq.put(old, freq.get(old) - 1);

            if (freq.get(old) == 0) {
                freq.remove(old);
            }

            // All elements are distinct
            if (freq.size() == k) {
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}