package com.djw.medium;

import org.junit.Test;

/**
 * @Author: dai jiawei
 * @Date: 2021/2/5 11:06
 */
public class Q1208_GetEqualSubstringsWithinBudget {

    /**
     * 给你两个长度相同的字符串，s 和 t。
     * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
     * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
     * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
     * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
     **/
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] accDiff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            accDiff[i + 1] = accDiff[i] + Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            int start = binarySearch(accDiff, i, accDiff[i] - maxCost);
            maxLength = Math.max(maxLength, i - start);
        }
        return maxLength;
    }

    public int binarySearch(int[] accDiff, int endIndex, int target) {
        int low = 0, high = endIndex;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (accDiff[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    @Test
    public void equalSubstring(){
        String s= "abcd";
        String t="bcdf";
        int maxCost= 3;
        int result = equalSubstring(s,t,maxCost);
        System.out.println(result);
    }
}
