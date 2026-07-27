class SLList_XY52 {

    SLLNode_XY head;

    public SLList_XY52() {
        head = null;
    }

    public SLList_XY(XY[] arr) {

        head = null;

        for (int i = arr.length - 1; i >= 0; i--) {
            prepend(arr[i]);
        }
    }

    public void prepend(XY v) {
        head = new SLLNode_XY(v, head);
    }

    public void insAfter(SLLNode_XY p, XY v) {

        if (p == null) return;

        p.next = new SLLNode_XY(v, p.next);
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