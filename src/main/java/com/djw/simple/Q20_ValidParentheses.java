package com.djw.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: dai jiawei
 * @Date: 2021/7/2 9:49
 */
public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        Map<Character,String> map = new HashMap<Character, String>();
        map.put(')',"(");
        map.put('}',"{");
        map.put(']',"[");
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if(map.containsKey(x)){
                if (stack.empty()){
                    return false;
                }
                String y =  stack.pop().toString();
                if(!y.equals(map.get(x))){
                    return false;
                }
            }else{
                stack.push(x);
            }
        }
        return stack.empty();
    }
}
