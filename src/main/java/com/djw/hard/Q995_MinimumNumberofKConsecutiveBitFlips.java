package com.djw.hard;

/**
 * @Author: dai jiawei
 * @Date: 2021/2/18 13:07
 */
public class Q995_MinimumNumberofKConsecutiveBitFlips {

    /**
     * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
     * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
     **/
    public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        int length = A.length;
        for (int i = 0; i < length ; i++) {
            if(A[i]==0) {
                ans++;
                boolean isTrue = true;
                while (isTrue) {
                    for (int j = 0; j < K; j++) {
                        i++;
                        if (i < length && A[i] == 0) {

                        }else{
                            isTrue =false;
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
