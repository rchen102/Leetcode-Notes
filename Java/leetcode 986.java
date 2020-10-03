class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int al = A[i][0], ar = A[i][1];
            int bl = B[j][0], br = B[j][1];
            // 存在交集
            if (al <= br && bl <= ar) {
                int[] intv = new int[2];
                intv[0] = Math.max(al, bl);
                intv[1] = Math.min(ar, br);
                res.add(intv);
            }
            if (ar > br) j++;
            else i++;
         }
         return res.toArray(new int[0][]);
    }
}