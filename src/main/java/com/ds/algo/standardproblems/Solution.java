package com.ds.algo.standardproblems;

import java.util.*;

/**
 * Classic Interview Problems – Arrays & Strings (Part 1).
 *
 * Each method is a standalone problem with clear description and complexity.
 */
public class Solution {

    // ═══════════════════════════════════════════════════════════════
    // 1. KADANE'S ALGORITHM – Maximum Subarray Sum
    //    LeetCode #53
    //    Time: O(n)  Space: O(1)
    // ═══════════════════════════════════════════════════════════════

    /**
     * At each index decide: extend the current subarray OR start fresh.
     * Track the global maximum seen so far.
     */
    public static int maxSubarraySum(int[] arr) {
        int currentMax = arr[0];
        int globalMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);  // extend or restart?
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }

    // ═══════════════════════════════════════════════════════════════
    // 2. SUBARRAY SUM EQUALS K  (prefix sum + HashMap)
    //    LeetCode #560
    //    Time: O(n)  Space: O(n)
    // ═══════════════════════════════════════════════════════════════

    /**
     * Key idea: if prefixSum[j] - prefixSum[i] == k, then subarray [i+1..j] sums to k.
     * Store prefix sums in a map; for each new sum, check if (sum - k) was seen before.
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);   // empty prefix
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += prefixCount.getOrDefault(sum - k, 0);
            prefixCount.merge(sum, 1, Integer::sum);
        }
        return count;
    }

    // ═══════════════════════════════════════════════════════════════
    // 3. LONGEST COMMON SUBSTRING  (DP)
    //    Time: O(n*m)  Space: O(n*m)
    // ═══════════════════════════════════════════════════════════════

    /**
     * dp[i][j] = length of common substring ending at s1[i-1] and s2[j-1].
     * If chars match: dp[i][j] = dp[i-1][j-1] + 1.  Else: 0.
     */
    public static int longestCommonSubstring(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLen = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }

    // ═══════════════════════════════════════════════════════════════
    // 4. LONGEST COMMON SUBSEQUENCE  (DP)
    //    LeetCode #1143
    //    Time: O(n*m)  Space: O(n*m)
    // ═══════════════════════════════════════════════════════════════

    /**
     * If chars match: dp[i][j] = dp[i-1][j-1] + 1.
     * Else: dp[i][j] = max(dp[i-1][j], dp[i][j-1]).
     */
    public static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    // ═══════════════════════════════════════════════════════════════
    // 5. LONGEST SUBSTRING WITHOUT REPEATING CHARACTERS
    //    LeetCode #3   (Sliding Window)
    //    Time: O(n)  Space: O(min(n, charset))
    // ═══════════════════════════════════════════════════════════════

    /**
     * Sliding window with a Set. Expand right; if duplicate, shrink left.
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // ═══════════════════════════════════════════════════════════════
    // 6. KTH LARGEST ELEMENT  (Min-Heap)
    //    LeetCode #215
    //    Time: O(n log k)  Space: O(k)
    // ═══════════════════════════════════════════════════════════════

    /**
     * Maintain a min-heap of size k. The top is always the kth largest.
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }

    // ──────────── Demo ────────────
    public static void main(String[] args) {
        System.out.println("Kadane           : " +
                maxSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));  // 6

        System.out.println("Subarray sum=7   : " +
                subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));        // 4

        System.out.println("LCSubstring      : " +
                longestCommonSubstring("abcde", "abfce"));                    // 2

        System.out.println("LCSubsequence    : " +
                longestCommonSubsequence("abcde", "ace"));                    // 3

        System.out.println("Longest no-repeat: " +
                lengthOfLongestSubstring("abcabcbb"));                        // 3

        System.out.println("2nd largest      : " +
                findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));            // 5
    }
}
