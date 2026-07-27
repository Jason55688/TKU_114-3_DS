class CLList_XY {

    Node_XY tail;

    // 空串列
    public CLList_XY() {
        tail = null;
    }

    // 利用陣列建立串列
    public CLList_XY(XY[] arr) {

        this();

        for (int i = 0; i < arr.length; i++) {
            append(arr[i]);
        }
    }

    // 尾端加入
    public void append(XY v) {

        Node_XY p = new Node_XY(v, null);

        // 第一個節點
        if (tail == null) {

            p.next = p;
            tail = p;
            return;
        }

        p.next = tail.next; // 新節點指向首節點
        tail.next = p;
        tail = p;
    }

    @Override
    public String toString() {

        String ans = "[ ";

        if (tail != null) {

            Node_XY p = tail.next; // head

            do {
                ans += p.data + ", ";
                p = p.next;
            }
            while (p != tail.next);
        }

        ans += "]";

        return ans;
    }
}