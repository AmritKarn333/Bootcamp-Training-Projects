class Solution {
    public double myPow(double x, int n) {
        long power = n;  // Important: avoid Integer.MIN_VALUE overflow

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1.0;

        while (power > 0) {
            // If current bit is 1
            if ((power & 1) == 1) {
                result *= x;
            }

            // Square the base
            x *= x;

            // Divide power by 2
            power >>= 1;
        }

        return result;
    }
}