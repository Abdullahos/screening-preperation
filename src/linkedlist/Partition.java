package linkedlist;

public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode l = null;
        ListNode r = null;

        ListNode lHead = null;
        ListNode rHead = null;


        while (head != null) {
            if (head.val <= x) {
                if (l != null) {
                    l.next = head;
                }
                else {
                    lHead = head;
                }
                l = head;
            }
            else {
                if (r != null) {
                    r.next = head;
                }
                else {
                    rHead = head;
                }
                r = head;
            }
            head = head.next;
        }

        if (l != null) {
            l.next = r;
        }
        if (r != null) {
            r.next = null;
        }

        return lHead == null ? rHead : lHead;
    }

}
