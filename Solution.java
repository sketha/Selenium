package demoTestNG.wrappers;

class BinaryGapCalculator {
    static int binaryGap(final int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n must be positive; was " + n);
        final int start = Integer.lowestOneBit(n) + 1, end = Integer.highestOneBit(n);
        int curRun = 0, longestRun = 0;
        for (int position = start; position < end; ++position) {
            final int bit = (n >>> position) & 1;
            if (bit == 0)
                ++curRun;
            else {
                longestRun = Math.max(longestRun, curRun);
                curRun = 0;
            }
        }
        return Math.max(longestRun, curRun);
    }
}