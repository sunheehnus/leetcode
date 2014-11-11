class MinStack {
    class Node {
        int value;
        int preMin;
        public Node(int value, int preMin) {
            this.value = value;
            this.preMin = preMin;
        }
    }
    ArrayList<Node> stack = new ArrayList<Node>();
    int minPos = -1;

    public void push(int x) {
        if (stack.size() == 0) {
            stack.add(new Node(x, -1));
            minPos = 0;
        }
        else {
            stack.add(new Node(x, minPos));
            if (x <= stack.get(minPos).value)
                minPos = stack.size() - 1;
        }
    }

    public void pop() {
        if (stack.size() != 0) {
            if (minPos == stack.size() - 1)
                minPos = stack.get(stack.size() - 1).preMin;
            stack.remove(stack.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1).value;
    }

    public int getMin() {
        return stack.get(minPos).value;
    }
}
