package com.djw.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: dai jiawei
 * @Date: 2021/3/4 16:28
 */
public class Q354_RussianDollEnvelopes {

    /**
     * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
     * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
     * 不允许旋转信封。
     **/
    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;

        //排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];//升序
                return o1[0] - o2[0];//升序
            }
        });

        //滑动窗口
        int[] f = new int[length];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;

    }
}
