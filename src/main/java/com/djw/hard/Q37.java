package com.djw.hard;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

 * @Author: dai jiawei
 * @Date: 2021/6/30 8:39
 */
public class Q37 {

     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) {
             val = x;
         }
     }

    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            //序列化二叉树
            StringBuilder s = new StringBuilder();//不考虑线程安全，效率优先
            if(root==null){
                s.append("#,");
            }else{
                s.append(root.val+",").append(serialize(root.left)).append(serialize(root.right));
            }
            return s.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            Queue<String> queue = new LinkedList<String>();
            for (int i = 0; i < nodes.length; i++) {
                queue.offer(nodes[i]);
            }
            return deserialize(queue);
        }

        public TreeNode deserialize(Queue<String> nodeList) {
            TreeNode treeNode = null;
            String value = nodeList.poll();
            if (!"#".equals(value)) {
                treeNode = new TreeNode(Integer.parseInt(value));
                treeNode.left = deserialize(nodeList);
                treeNode.right = deserialize(nodeList);
            }
            return treeNode;
        }

        public static void main(String[] args) {
            TreeNode a = new TreeNode(1);
            TreeNode a1 = new TreeNode(1);
            TreeNode a2 = new TreeNode(1);
            TreeNode a21 = new TreeNode(1);
            TreeNode a22 = new TreeNode(1);
            a2.left=a21;
            a2.right=a22;
            a.left=a1;
            a.right=a2;
            Codec codec = new Codec();
            TreeNode x =codec.deserialize(codec.serialize(a));
            System.out.println(x.toString());
        }
    }
}
