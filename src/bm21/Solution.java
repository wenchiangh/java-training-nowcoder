import java.util.*;

/**
 * BM21 旋转数组的最小数字
 */
public class Solution {
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] == array[right]) {
                right = right - 1;
            } else {
                left = mid + 1;
            }
        }

        return array[left];
    }
}