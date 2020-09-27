class MedianFinder {

    PriorityQueue<Integer> maxH = new PriorityQueue<>(10, (a, b) -> b-a);
    PriorityQueue<Integer> minH = new PriorityQueue<>();

    int total = 0;

    /** initialize your data structure here. */
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        total++;
        if (total == 1) {
            maxH.offer(num);
        } else {
            if (num <= maxH.peek()) maxH.offer(num);
            else minH.offer(num);
        }
        // 调整
        int maxSize = maxH.size();
        int minSize = minH.size();
        if (maxSize == minSize || maxSize - minSize == 1) return;
        if (maxSize > minSize) {
            int tmp = maxH.poll();
            minH.offer(tmp);
        }
        else {
            int tmp = minH.poll();
            maxH.offer(tmp);
        }
    }
    
    public double findMedian() {
        if (total == 0) return 0.0d;
        if (total % 2 == 1) return maxH.peek();
        else {
            double n1 = maxH.peek();
            double n2 = minH.peek();
            return (n1 + n2) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */