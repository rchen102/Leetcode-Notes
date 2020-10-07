// 就是个归并排序，不过在归并排序过程中统计了一下逆序对
class Solution {
    public int reversePairs(int[] nums) {
        // 利用归并排序，合并时，进行计算
        if (nums == null || nums.length == 0) return 0;
        return countReverse(nums, 0, nums.length - 1);
    }

    int countReverse(int[] arr, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + ((hi - lo) >> 1);
        int left = countReverse(arr, lo, mid);
        int right = countReverse(arr, mid+1, hi);
        int res = merge(arr, lo, hi);
        return res + left + right;
    }

    // merge [lo, mid]  [mid+1, hi]
    int merge(int[] arr, int lo, int hi) {
        int mid = lo + ((hi - lo) >> 1);
        int[] tmp = new int[hi-lo+1];
        int i = lo, j = mid+1, k = 0;
        int res = 0;
        while (i <= mid && j <= hi) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++]; 
            }
            else {
                tmp[k++] = arr[j++];
                res += mid - i + 1;
            }
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= hi) tmp[k++] = arr[j++];
        k = 0;
        while (k < hi - lo + 1) {
            arr[lo+k] = tmp[k];
            k++;
        }
        return res;
    }
}


// 会超时
class Solution {
    public int reversePairs(int[] nums) {
        // 冒泡排序，每次交换，逆序度减一
        // 插入排序，每次移动，逆序度减一
        int res = 0;
        int n = nums.length;
        boolean flag; // 本轮交换是否有数据交换
        for (int i = 0; i < n; i++) {
            flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j ,j+1);
                    flag = true;
                    res++;
                }
            }
            if (!flag) break;
        }
        return res;
    }

    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}