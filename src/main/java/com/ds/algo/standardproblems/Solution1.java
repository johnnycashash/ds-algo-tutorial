package com.ds.algo.standardproblems;

import java.util.*;

class Solution1 {

    /*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
    Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
     */
    public static void moveZeroes(int[] nums) {
        int z = -1;
        int c = 1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                if (z == -1) z = i;
                else c++;
            } else {
                if (z != -1) {
                    int t = nums[z];
                    nums[z] = nums[i];
                    nums[i] = t;
                    i = i - c;
                    c = 1;
                    z = -1;
                }
            }
        }
    }

    /*
    Given an array of strings, group anagrams together.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();
        for (String s :
                strs) {

            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            if (store.containsKey(sorted)) {
                store.get(sorted).add(s);
            } else {
                List<String> value = new ArrayList<String>();
                value.add(s);
                store.put(sorted, value);
            }
        }
        return new ArrayList<>(store.values());
    }

    /*
    Given an integer array arr, count element x such that x + 1 is also in arr.

If there're duplicates in arr, count them seperately.



Example 1:

Input: arr = [1,2,3]
Output: 2
Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
Example 2:

Input: arr = [1,1,3,3,5,5,7,7]
Output: 0
Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
Example 3:

Input: arr = [1,3,2,3,5,0]
Output: 3
Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
Example 4:

Input: arr = [1,1,2,2]
Output: 2
Explanation: Two 1s are counted cause 2 is in arr.


Constraints:

1 <= arr.length <= 1000
0 <= arr[i] <= 1000
     */
    public static int countElements(int[] arr) {
        int count = 0;
        int temp[] = new int[1100];
        for (int i :
                arr) {

            temp[i] = 1;
        }
        for (int i :
                arr) {
            if (temp[i + 1] == 1) {
                count++;
            }
        }
        return count;
    }

    /*
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,1]
    Output: 1
    Example 2:

    Input: [4,1,2,1,2]
    Output: 4
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums
        ) {
            boolean add = set.add(i);
            if (!add) {
                set.remove(i);
            }

        }
        return set.stream().findFirst()
                .get();
    }

    public int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (nums[i] == 0) ? -1 : 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }
        return maxLength;
    }
}