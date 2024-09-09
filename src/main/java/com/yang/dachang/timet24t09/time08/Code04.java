package com.yang.dachang.timet24t09.time08;

import java.util.Stack;

/**
 * 给你一个栈，不申请任何其它数据结构，请你翻转它
 */
public class Code04 {

    public static void main(String[] args) {

    }

    public static void getTarget(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = f(stack);
        getTarget(stack);
        stack.push(i);
    }

    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }

}
