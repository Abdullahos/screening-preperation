package linkedlist;

public class Sum {

    public ListNode sum(ListNode h1, ListNode h2) {
        if (h1 == null && h2 == null) return null;

        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode cur;
        int carry = calculateAndReturnCarry(h1, h2, head, 0);
        h1 = h1 != null ? h1.next : null;
        h2 = h2 != null ? h2.next : null;

        while (h1 != null || h2 != null) {
            cur = new ListNode(0);

            carry = calculateAndReturnCarry(h1, h2, cur, carry);

            pre.next = cur;
            pre = cur;

            h1 = h1 != null ? h1.next : null;
            h2 = h2 != null ? h2.next : null;

        }

        if (carry > 0) {
            cur = new ListNode(carry);
            pre.next = cur;
        }

        return head;
    }

    private int calculateAndReturnCarry(ListNode h1, ListNode h2, ListNode cur, int carry) {
        if (h1 != null) {
            cur.val += h1.val;
        }
        if (h2 != null) {
            cur.val += h2.val;
        }
        cur.val += carry;

        int curVal = cur.val;

        cur.val %= 10;

        return curVal / 10;
    }

    public static void main(String[] args) {
        Sum sum = new Sum();
        ListNode head1 = new ListNode(7);
        ListNode n11 = new ListNode(1);

        head1.next = n11;


        ListNode head2 = new ListNode(5);
        ListNode n21 = new ListNode(9);
        ListNode n22 = new ListNode(9);

        head2.next = n21;
        n21.next = n22;

        sum.sum(head1, head2);

    }

}
