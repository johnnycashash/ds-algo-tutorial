package com.ds.algo.standardproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem
public class Solution {
    public static void main(String[] args) {
        // System.out.println(longestCommonSubsequence("abcd", "aebgh"));
        System.out.println(maxSumSubArrayStandardKadane(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        //System.out.println(lcsubstring("aganstransfot","tzgantransport"));
    }


    static int maxSumSubArrayStandardKadane(int arr[]) {
        int current_maximum = arr[0];
        int maximum_so_far = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current_maximum = Math.max(arr[i], current_maximum + arr[i]); //should we include current element or
            // start from here fresh
            maximum_so_far = Math.max(maximum_so_far, current_maximum); //update only if current max exceeds our
            // existing max
        }
        return maximum_so_far;
    }

    public static int subArraySumEqualK(int[] arr, int sum) {
        int cur_sum = 0;
        int start;
        int maxLen = 0;
        int mxStart = 0;
        int mxEnd = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int end = 0; end < arr.length; end++) {
            cur_sum = cur_sum + arr[end];

            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                System.out.println("Sum found between indexes " + start + " to " + end);
                if (end - start + 1 > maxLen) {//Math.max
                    maxLen = end - start + 1;
                    mxStart = start;
                    mxEnd = end;
                }
            }
            hashMap.put(cur_sum, end);

        }
        System.out.println(mxStart + " " + mxEnd);
        return mxEnd - mxStart + 1;
    }

    static void kSumSubArraySliding(int[] arr, int k) {
        int start = 0;
        int sum = arr[0];
        for (int end = 1; end <= arr.length; end++) {

            while (sum > k && start < end - 1) {
                sum = sum - arr[start];
                start++;
            }

            if (sum == k) {
                System.out.println(start + " " + end);
            }
            if (end < arr.length)
                sum += arr[end];

        }
    }

    public static int maxSumSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            maxSum = Math.max(sum, maxSum);
            sum = Math.max(sum, 0);
        }
        return maxSum;
    }

    public static int maxSubArrayLenWithSum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }

        return maxLength;
    }

    static int lcsubstring(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int result = 0;
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                    result = Integer.max(result, dp[i + 1][j + 1]);
                }
            }
        }
        return result;
    }

    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }

        }
        int len = dp[text1.length()][text2.length()];
        int returned = len;

        char[] out = new char[len];
        int i = text1.length(), j = text2.length();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                out[--len] = text1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }

        }
        return returned;
    }

    public int lengthOfLongestSubstring(String s) {
        int startPointer = 0;
        int endPointer = 0;
        int maxLength = 0;
        Set<Character> substringSet = new HashSet<>();
        while (endPointer < s.length()) {
            if (!substringSet.contains(s.charAt(endPointer))) {
                substringSet.add(s.charAt(endPointer));
                endPointer++;
                maxLength = Math.max(substringSet.size(), maxLength);
            } else {
                substringSet.remove(s.charAt(startPointer));
                startPointer++;
            }
        }
        return maxLength;
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.remove();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.remove();
                heap.add(nums[i]);
            }
        }

        return heap.remove();
    }

    public int thirdMax(int[] nums) {
        //there are repeated numbers in array
        //if 3rd only then go for 3 max manipulation
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);

                heap.add(num);
                if (heap.size() > 3) {
                    heap.remove();
                }
            }
        }
        if (heap.size() < 3) {
            while (heap.size() > 1) {
                heap.poll();
            }
        }
        return heap.remove();
    }
}
