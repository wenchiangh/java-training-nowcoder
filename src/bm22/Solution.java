import java.util.*;

/**
 * BM22 比较版本号
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * 
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare(String version1, String version2) {
        int i1 = 0, i2 = 0;

        while (i1 < version1.length() || i2 < version2.length()) {
            long v1 = 0;
            while (i1 < version1.length() && version1.charAt(i1) != '.') {
                v1 = v1 * 10 + Character.getNumericValue(version1.charAt(i1));
                i1 = i1 + 1;
            }

            if (i1 < version1.length() && version1.charAt(i1) == '.') {
                i1 = i1 + 1;
            }

            long v2 = 0;
            while (i2 < version2.length() && version2.charAt(i2) != '.') {
                v2 = v2 * 10 + Character.getNumericValue(version2.charAt(i2));
                i2 = i2 + 1;
            }

            if (i2 < version2.length() && version2.charAt(i2) == '.') {
                i2 = i2 + 1;
            }

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }

        }

        return 0;
    }
}