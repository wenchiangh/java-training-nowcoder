import java.util.*;

/**
 * BM20 数组中的逆序对
 */
public class Solution {
    public int InversePairs(int[] array) {
        int sortLength = 2;

        while (sortLength < array.length) {

            for (int ii = 0; ii < array.length;) {
            
                ii = ii + sortLength;
            }

            sortLength = sortLength * 2;
        }
    }
}