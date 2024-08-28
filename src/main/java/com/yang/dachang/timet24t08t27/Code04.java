package com.yang.dachang.timet24t08t27;

import java.util.Stack;

/**
 * 不用额外数据结构完成栈重排
 */
public class Code04 {

    public static void main(String[] args) {
        Stack<Object> objects = new Stack<>();
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
