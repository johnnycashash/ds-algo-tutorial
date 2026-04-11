package com.ds.algo.standardproblems;

import java.util.Arrays;

/**
 * Classic Interview Problems – Part 4 (String manipulation).
 */
public class Solution3 {

    // ═══════════════════════════════════════════════════════════════
    // 1. REVERSE A STRING  (two pointers)
    //    Time: O(n)  Space: O(1) (in-place on char array)
    // ═══════════════════════════════════════════════════════════════

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }

    // ═══════════════════════════════════════════════════════════════
    // 2. CHECK PALINDROME
    //    Time: O(n)  Space: O(1)
    // ═══════════════════════════════════════════════════════════════

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    // ═══════════════════════════════════════════════════════════════
    // 3. CHECK ANAGRAM
    //    Time: O(n)  Space: O(1) – 26-char frequency array
    // ═══════════════════════════════════════════════════════════════

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }

    // ═══════════════════════════════════════════════════════════════
    // 4. REVERSE WORDS in a sentence
    //    "hello world" → "world hello"
    //    Time: O(n)  Space: O(n)
    // ═══════════════════════════════════════════════════════════════

    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }

    // ═══════════════════════════════════════════════════════════════
    // 5. FIRST NON-REPEATING CHARACTER
    //    LeetCode #387
    //    Time: O(n)  Space: O(1) – 26-char frequency array
    // ═══════════════════════════════════════════════════════════════

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    // ──────────── Demo ────────────
    public static void main(String[] args) {
        System.out.println("Reverse    : " + reverseString("interview"));       // weivretni
        System.out.println("Palindrome : " + isPalindrome("racecar"));          // true
        System.out.println("Anagram    : " + isAnagram("listen", "silent"));    // true
        System.out.println("Rev words  : " + reverseWords("hello world foo"));  // foo world hello
        System.out.println("First uniq : " + firstUniqChar("leetcode"));        // 0 (l)
    }
}
