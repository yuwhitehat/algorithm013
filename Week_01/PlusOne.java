class PlusOne{
    /**
     *两种情况
     *1.小于9直接加一返回
     *2.等于9就置为零，如果是999这种情况就要重新开辟数组，原来数组长度加一，将最高位置为1
     * 时间复杂度：O(n)
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1;i >= 0;i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[n+1];
        digits[0] = 1;
        return digits;
    }
}