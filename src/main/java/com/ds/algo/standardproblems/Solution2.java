package com.ds.algo.standardproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2 {
    public static void main(String args[]) {
        List<List<String>> list = new ArrayList<>();
        ArrayList<String> e = new ArrayList<>();
        e.add("hgj");
        list.add(e);
        e.add("jhjgh");
        list.add(e);
        System.out.println(list.stream().flatMap(strings -> strings.stream()).collect(Collectors.toList()));
        List<String> collect = list.stream().flatMap(strings -> strings.stream()).limit(2).collect(Collectors.toList());
        IntStream.range(0, collect.size())
                .filter(n -> n % 3 == 0)
                .mapToObj(collect::get)
                .collect(Collectors.toList());

        String original = "bcdbcdbcdbcd";
        String original_two = "bcdbcdbcd";
        String to_be_divided_with_str = "bcdbcd";
        System.out.println(findSmallestDivisor(original, to_be_divided_with_str));
        System.out.println(findSmallestDivisor(original_two, to_be_divided_with_str));


        //		String str = "((((";
//		String str = "(()))";
//		String str = ")))(((";
        String str = ")))(";
//		String str = "";
//		String str = "((()";
//		String str = "((()))";
        System.out.println(getMinOperations(str));


        int[] arr = {5, 5, 2, 5, 8};
        System.out.println(countBalancingElements(arr));
    }

    static int countBalancingElements(int[] arr) {
        // Just calculate sumOfEven and sumOfOdd by iterating over all elements
        int odd = 0, even = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                even += arr[i];
            else
                odd += arr[i];
        }
        int ans = 0;
        int prevOdd = 0, prevEven = 0;
        for (int i = 0; i < arr.length; i++) {
            int nextEven = even - prevEven;
            int nextOdd = odd - prevOdd;
            if (i % 2 == 0) // Subtract values based on odd/even index values. This will return the
                // nextEven/nextOdd values from the remaining array
                nextEven -= arr[i];
            else
                nextOdd -= arr[i];
            // [0,1,2,3,4]
            if (prevOdd + nextEven == prevEven + nextOdd) // If remaining values are same from odd&even, increment the
                // ans.
                ans++;
            if (i % 2 == 0) // Keep adding Values to previousOdd & Even array
                prevEven += arr[i];
            else
                prevOdd += arr[i];
        }


//		for (int i = 0; i < arr.length; i++) {
//			int nextEven = 0, nextOdd = 0;
//			if (i % 2 == 0) {
//				nextEven = even - prevEven - arr[i];
//				nextOdd = odd - prevOdd;
//			} else {
//				nextEven = even - prevEven;
//				nextOdd = odd - prevOdd - arr[i];
//			}
//
//			if (prevEven + nextOdd == prevOdd + nextEven)
//				ans++;
//			if (i % 2 == 0)
//				prevEven += arr[i];
//			else
//				prevOdd += arr[i];
//		}
        return ans;
    }

    static int countBalancingElements_AnotherSolution(int[] arr) {
        int ways = 0;

        for (int i = 0; i < arr.length; i++) {
            if (validate(i, arr))
                ways++;
        }
        return ways;
    }

    static boolean validate(int index, int[] arr) {
        int odd = 0;
        int even = 0;

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) // Ignore current running index
                continue;
            if (counter % 2 == 0) {
                even += arr[i];
            } else {
                odd += arr[i];
            }
            counter++;
        }
        return (odd == even);
    }

    private static int findSmallestDivisor(String s, String t) {
        // This means that the length t string cannot be multiplied to get to original string. Hence return false
        if (s.length() % t.length() > 0)
            return -1;
        StringBuilder sb = new StringBuilder();
        int divisor = s.length() / t.length();
        for (int i = 0; i < divisor; i++) //Multiple t string with it's number of t times to get to original string
            sb.append(t);
        if (!sb.toString().equals(s)) // If both strings not equals even after appending return -1
            return -1;
        // Meat of the code
        for (int i = 1; i <= t.length(); i++) {
            sb = new StringBuilder();
            //Extract char by char and duplicate it until the length of t string is reached.
            //Once reached, check if they are equal. If yes, then return the i iteration value.
            String subStr = t.substring(0, i);
            while (sb.length() < t.length()) {
                sb.append(subStr);
            }
            if (sb.toString().equals(t))
                return i;
        }
        return -1;
    }


    // Assumption that only string will only contain ( & ) chars. If other characters are passed, we need to
    //throw a runtime exception or eliminate using regex. These are not included as a part of below solution.

    private static int getMinOperations(String str) {
        int answer = 0, balance = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                balance++; // Increment the value to 1, indicates and opening bracket was encountered
            } else {
                balance--; // Decrement by 1, indicates and closing bracket was encountered
            }

            // ((((, means below condition will not execute and balance will have value of 4
            // from above if check.
            if (balance == -1) {
                answer++;
                balance++;
            }
        }

        return answer + balance;
//		return Math.abs(balance);

    }
}
