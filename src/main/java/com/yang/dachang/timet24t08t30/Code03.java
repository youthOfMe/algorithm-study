package com.yang.dachang.timet24t08t30;

import java.util.List;

/**
 * 多叉树和二叉树相互转换
 */
public class Code03 {

    public static void main(String[] args) {

    }

    /**
     * 多叉树结构
     */
    public static class MoreTree {
        public int value;
        public List<MoreTree> childNodeList;

        public MoreTree(int value) {
            this.value = value;
        }

        public MoreTree(int value, List<MoreTree> childNodeList) {
            this.value = value;
            this.childNodeList = childNodeList;
        }
    }

    public static class TwoTree {
        public int value;
        public TwoTree left;;
        public TwoTree right;

        public TwoTree() {

        }

        public TwoTree(int value) {
            this.value = value;
        }
    }

    public static TwoTree moreTreeToTwoTree(MoreTree moreTree) {

        if (moreTree == null) {
            return null;
        }

        TwoTree twoTree = new TwoTree();
        if (moreTree.childNodeList == null) {
            twoTree.value = moreTree.value;
            return twoTree;
        }

        twoTree.value = moreTree.value;
        twoTree.left = en(moreTree.childNodeList);
        return twoTree;
    }

    /**
     * 多叉树转二叉树递归函数
     * @param list
     * @return
     */
    public static TwoTree en(List<MoreTree> list) {
        TwoTree head = null;
        TwoTree cur = null;
        for (MoreTree moreTree : list) {
            TwoTree twoTree = new TwoTree(moreTree.value);
            if (head == null) {
                head = twoTree;
            } else {
                cur.left = twoTree;
            }
            cur = twoTree;
            cur.left = en(moreTree.childNodeList);
        }
        return head;
    }

}
