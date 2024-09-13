package com.yang.dachang.timet24t09.time12;

/**
 * 数字字符串问题
 */
public class Code01 {

    public static void main(String[] args) {

    }

    public static int getTarget(String target) {
        if (target == null && target.isEmpty()) return 0;
        return process(target.toCharArray(), 0);
    }

    public static int process(char[] tarArr, int index) {
        if (tarArr.length == index) return 1;
        // 如果为0就是扯淡
        if (tarArr[index] == '0') return 0;
        // 转换这个字符
        int m1 = process(tarArr, index + 1);
        // 不转换这个字符
        int m2 = 0;
        if ((tarArr[index] - '0') * 10 + (tarArr[index + 1] - '0') < 27) {
            m2 = process(tarArr, index + 2);
        }
        return m1 + m2;
    }

}
