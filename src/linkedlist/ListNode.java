package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.getNext();
        }
        return length;
    }

    public int getKthNodeFromBehind_more_t_less_s(ListNode head, int k) throws Exception {
        int length = getLength(head);
        if (k > length) {
            throw new Exception("k exceeds length");
        }
        for (int i = 0; i < length - k; i++) {
            head = head.getNext();
        }
        if (head == null) {
            throw new Exception("K must be smaller the size");
        }
        return head.val;
    }

    public int getKthNodeFromBehind_less_t_more_s(ListNode head, int k) throws Exception {
        if (head == null) {
            return 0;
        }
        int length = getLength(head) + 1;
        if (k == length) {
            System.out.println(head.val);
        }
        return length;
    }
}
