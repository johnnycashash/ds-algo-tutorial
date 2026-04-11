package com.ds.algo.standardproblems;

import java.util.*;

/**
 * Classic Interview Problems – Part 2.
 */
public class Solution1 {

    // ═══════════════════════════════════════════════════════════════
    // 1. MOVE ZEROES to end (maintain relative order)
    //    LeetCode #283
    //    Time: O(n)  Space: O(1)
    // ═══════════════════════════════════════════════════════════════

    /**
     * Two-pointer: 'insertPos' tracks where the next non-zero should go.
     * Swap non-zero element with position at insertPos.
     */
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                insertPos++;
            }
        }
    }

    // ═══════════════════════════════════════════════════════════════
    // 2. GROUP ANAGRAMS
    //    LeetCode #49
    //    Time: O(n * k log k)  Space: O(n * k)  (k = max word length)
    // ═══════════════════════════════════════════════════════════════

    /**
     * Sort each word → use sorted form as map key → group originals.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // ═══════════════════════════════════════════════════════════════
    // 3. SINGLE NUMBER (every element appears twice except one)
    //    LeetCode #136
    //    Time: O(n)  Space: O(1)
    // ═══════════════════════════════════════════════════════════════

    /**
     * XOR trick: a ^ a = 0, a ^ 0 = a.
     * XOR all elements → duplicates cancel out → single number remains.
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }

    // ═══════════════════════════════════════════════════════════════
    // 4. CONTIGUOUS ARRAY (equal 0s and 1s)
    //    LeetCode #525
    //    Time: O(n)  Space: O(n)
    // ═══════════════════════════════════════════════════════════════

    /**
     * Replace 0→-1, then find longest subarray with sum=0 using prefix sum + map.
     */
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(sum))
                maxLen = Math.max(maxLen, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return maxLen;
    }

    // ═══════════════════════════════════════════════════════════════
    // 5. COUNT ELEMENTS where x+1 also exists
    //    Time: O(n)  Space: O(n)
    // ═══════════════════════════════════════════════════════════════

    public static int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        int count = 0;
        for (int num : arr) {
            if (set.contains(num + 1)) count++;
        }
        return count;
    }

    // ──────────── Demo ────────────
    public static void main(String[] args) {
        int[] zeros = {0, 1, 0, 3, 12};
        moveZeroes(zeros);
        System.out.println("Move zeroes    : " + Arrays.toString(zeros));   // [1,3,12,0,0]

        System.out.println("Group anagrams : " +
                groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("Single number  : " +
                singleNumber(new int[]{4, 1, 2, 1, 2}));                    // 4

        System.out.println("Max equal 0/1  : " +
                findMaxLength(new int[]{0, 1, 0, 1, 0, 1, 1}));            // 6

        System.out.println("Count elements : " +
                countElements(new int[]{1, 2, 3}));                          // 2
    }
}