import java.util.*;

/**
 * BM18 二维数组中的查找
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        // zero matrix
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }

        // column number
        int col = array[0].length - 1;
        // from first row right column,
        for (; col > -1; col--) {
            if (array[0][col] == target) {
                // that is target, return true
                return true;
            } else if (array[0][col] > target) {
                // that max than target,
                // all elements in the column max than target, move to left
                continue;
            } else {
                // that less than target,
                // may have target in the column, b-search in the column
                int left = 0, right = array.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (array[mid][col] == target) {
                        return true;
                    } else if (array[mid][col] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        return false;
    }
}