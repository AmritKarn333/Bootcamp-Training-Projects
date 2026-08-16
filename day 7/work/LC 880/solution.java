class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;

        // Find the size of the decoded string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }

        // Work backwards
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int digit = c - '0';

                size /= digit;
                k %= size;

            } else {
                if (k == 0 || k == size) {
                    return String.valueOf(c);
                }

                size--;
            }
        }

        return "";
    }
}