public class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int i = 0, j = 0;
        int[] res = new int[m + n];
        int length = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                res[length] = nums2[j];
                j++;
            } else {
                res[length] = nums1[i];
                i++;
            }
            length++;
        }
        if (i == m) {
            for (int k = j; k < n; k++) {
                res[length] = nums2[k];
                length++;
            }
        }
        if (j == n) {
            for (int k = i; k < m; k++) {
                res[length] = nums1[k];
                length++;
            }
        }

        for (int k = 0; k < m + n; k++) {
            nums1[k] = res[k];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 3, 6};
        merge(nums1, 3, nums2, 3);
    }
}
