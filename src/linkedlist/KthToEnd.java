package linkedlist;

public class KthToEnd {


    public ListNode kthToEndRec(ListNode head, int k) {
        return kthToEndRec(head, new Index(), k);
    }
    //recursive
    public ListNode kthToEndRec(ListNode head, Index index, int k) {
        if (head == null) {
            return null;
        }
        ListNode node = kthToEndRec(head.next, index, k);
        if (index.value == k) {
            return head;
        }
        index.value++;
        return node;
    }

    //linear
    public ListNode kthToEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                throw new RuntimeException("K can't be bigger that the size of the list");
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


}

class Index {
    int value;
}
