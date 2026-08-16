import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 occurs before the array starts
        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (map.containsKey(sum)) {
                int previousIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}