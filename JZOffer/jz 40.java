// Solution1: heap
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> b -a);
        for (int i = 0; i < arr.length; i++) {
            if (heap.size() < k) {
                heap.offer(arr[i]);
            }
            else {
                if (arr[i] < heap.peek()) {
                    heap.poll();
                    heap.offer(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}

// Solution2: 快排 partion 函数
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k == 0) return new int[0];
        int lo = 0, hi = arr.length - 1, target = k;
        while (lo <= hi) {
            int pivot_idx = partition(arr, lo, hi);
            int rank = pivot_idx - lo + 1;
            if (rank == target) {
                return buildResult(arr, k);
            }
            else if (rank > target) {
                hi = pivot_idx - 1;
            }
            else if (rank < target) {
                lo = pivot_idx + 1;
                target = target - rank;
            }
        }
        return new int[0];

    }

    public int[] buildResult(int[] arr, int k) {
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i;
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}