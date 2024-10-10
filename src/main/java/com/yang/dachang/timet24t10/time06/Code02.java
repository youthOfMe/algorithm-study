package com.yang.dachang.timet24t10.time06;

/**
 * 暴力求解第字串存在的最先位置
 */
public class Code02 {

    public static void main(String[] args) {
        String str1 = "aaa123";
        String str2 = "123";
        System.out.println(getTarget(str1, str2));
    }

    public static int getTarget(String str1, String str2) {
        if (str1 == null || str2 == null) return -1;
        final int len1 = str1.length();
        final int len2 = str2.length();
        if (len1 < len2) return -1;
        int cur = 0;
        int res = -1;
        char[] strChars1 = str1.toCharArray();
        char[] strChars2 = str2.toCharArray();
        while (cur <= (len1 - len2)) {
            res = cur;
            for (int index = 0; index < len2; index++) {
                if (strChars1[cur + index] != strChars2[index]) {
                    res = -1;
                    break;
                }
            }
            if ((res - cur) == (len2 -1)) {
                break;
            }
            cur++;
        }
        return res;
    }

}
