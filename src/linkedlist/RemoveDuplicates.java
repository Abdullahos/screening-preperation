package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    //Using set
    public ListNode deleteDuplicatesNotSorted(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        ListNode cur = head;

        set.add(cur.val);

        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            }
            else {
                set.add(cur.next.val);
                cur = cur.next;
            }
        }

        return head;

    }

    public ListNode deleteDuplicatesNotSortedWithNoAdditionalSpace(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode s = head;
        ListNode f = head;

        while (s != null) {
            while (f.next != null) {
                if (s.val == f.next.val) {
                    f.next = f.next.next;
                }
                else {
                    f = f.next;
                }
            }
            s = s.next;
            f = s;
        }

        return head;

    }


    public ListNode deleteDuplicatesSorted(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next, prev = head;

        while (cur != null) {
            if (cur.val == prev.val) {
                cur = cur.next;
                continue;
            }
            prev.next = cur;
            prev = cur;
            cur = cur.next;
        }

        prev.next = null;


        return head;
    }

}
