class SLList_XY {

    SLLNode_XY head;

    // 建立空串列
    public SLList_XY() {
        head = null;
    }

    // 利用陣列建立串列
    public SLList_XY(XY[] arr) {

        head = null;

        for (int i = arr.length - 1; i >= 0; i--) {
            prepend(arr[i]);
        }
    }

    // 插到串列前端
    public void prepend(XY v) {
        head = new SLLNode_XY(v, head);
    }

    @Override
    public String toString() {

        String ans = "[ ";

        SLLNode_XY p = head;

        while (p != null) {
            ans += p.data + ", ";
            p = p.next;
        }

        ans += "]";

        return ans;
    }
}