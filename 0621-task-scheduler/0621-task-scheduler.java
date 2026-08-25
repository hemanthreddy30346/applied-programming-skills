class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char c : tasks) {
            count[c - 'A']++;
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        int maxCount = 0;

        for (int c : count) {
            if (c == max) {
                maxCount++;
            }
        }

        int result = (max - 1) * (n + 1) + maxCount;

        return Math.max(result, tasks.length);
    }
}