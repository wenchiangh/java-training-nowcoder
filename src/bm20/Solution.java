import java.util.*;

/**
 * BM20 数组中的逆序对
 */
public class Solution {
    public int InversePairs(int[] array) {
        int ctl = MergeSort(array, 0, array.length - 1);
        return ctl % 1000000007;
    }

    public static int MergeSort(int[] array, int m, int n) {
        // System.out.println(m + "\t" + n);
        int ctl = 0;
        // exit point
        if (m == n) {
            return ctl;
        }
        // split two array
        int mid = m + (n - m) / 2;
        int ctlLeft = MergeSort(array, m, mid);
        int ctlRight = MergeSort(array, mid + 1, n);

        // test of range
        for (int r = mid + 1; r <= n; r++) {
            for (int l = m; l <= mid; l++) {
                if (array[l] > array[r]) {
                    ctl = ctl + (mid - l + 1);
                    break;
                }
            }
        }
        ctl = (ctl % 1000000007) + ctlLeft + ctlRight;

        // merge two array
        int[] temp = new int[n - m + 1];
        int p1 = m, p2 = mid + 1, p3 = 0;
        while (p1 <= mid && p2 <= n) {
            if (array[p1] < array[p2]) {
                temp[p3++] = array[p1++];
            } else {
                temp[p3++] = array[p2++];
            }
        }

        while (p1 <= mid) {
            temp[p3++] = array[p1++];
        }

        while (p2 <= n) {
            temp[p3++] = array[p2++];
        }

        for (int ii = 0; ii < temp.length; ii++) {
            array[m + ii] = temp[ii];
        }

        // return
        return ctl;
    }

    public static void main(String[] args) {
        int[] arr = { 364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407,
                416, 366, 315, 301, 601, 650, 418,
                355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149,
                588, 233, 144, 174, 557, 67,
                746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256,
                936, 275, 401, 497, 82, 935,
                983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655,
                446, 863, 735, 784, 3, 671,
                433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811,
                267, 575 };
        // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 0 };
        Solution s = new Solution();
        int c = s.InversePairs(arr);

        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println(c);
    }
}