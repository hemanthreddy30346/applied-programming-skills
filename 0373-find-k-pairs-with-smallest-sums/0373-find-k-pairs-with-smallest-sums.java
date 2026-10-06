import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Add first k possible pairs
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {

            int[] current = pq.poll();

            int sum = current[0];
            int i = current[1];
            int j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Move to next element in nums2
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }

            k--;
        }

        return result;
    }
}