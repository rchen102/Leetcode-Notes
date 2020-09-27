// Solution1: using 2 stack T: O(1)
class MinStack {

    Stack<Integer> data;
    Stack<Integer> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        // 1. 压入数据栈
        data.push(x);
        // 2. 寻找当前最小值，压入 minStack
        if (minStack.isEmpty()) {
            // 第一个元素
            minStack.push(x);
        }
        else {
            if (x < minStack.peek()) minStack.push(x);
            else minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        data.pop();
        minStack.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//Solution2: creat a new data structure
class MinStack {
    
    class Node {
        int val;
        int min;
        Node next;
    
        public Node() {}
        
        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    
    Node head; 

    /** initialize your data structure here. */
    public MinStack() {
        // 虚拟头结点
        head = new Node();
    }
    
    public void push(int x) {
        Node newNode;
        if (head.next == null) {
            newNode = new Node(x, x);
        }
        else {
            int curMin = Math.min(head.next.min, x);
            newNode = new Node(x, curMin);
        }
        newNode.next = head.next;
        head.next = newNode;
    }
    
    public void pop() {
        if (head.next != null) {
            head = head.next;
        }
    }
    
    public int top() {
        if (head.next == null) {
            throw new RuntimeException("Stack is empty!");
        }
        else {
            return head.next.val;
        }
    }
    
    public int getMin() {
        if (head.next == null) {
            throw new RuntimeException("Stack is empty!");
        }
        else {
            return head.next.min;
        }
    }
}