class Solution {
    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;

        for (int[] customer : accounts) {

            int sum = 0;

            for (int money : customer) {
                sum += money;
            }

            if (sum > maxWealth) {
                maxWealth = sum;
            }
        }

        return maxWealth;
    }
}