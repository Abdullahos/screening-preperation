package linkedlist;

import java.util.Stack;

public class Palindrome {
    // t = O(n), s = O(n)
    public boolean isPalindrome(ListNode head) {
        ListNode s = head, f = head;
        Stack<Integer> stk = new Stack<>();

        while (f != null && f.next != null) {
            stk.push(s.val);
            s = s.next;
            f = f.next.next;
        }

        if (f != null && f.next == null) {
            s = s.next;
        }

        while (s != null) {
            if (stk.isEmpty() || s.val != stk.pop()) {
                return false;
            }
            s = s.next;
        }

        return true;
    }

    //t: O(n), s: O(1), but input modified, it can be recovered
    public boolean isPalindromeNoExtraSpace(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = null;
        ListNode temp;
        ListNode fastTemp;


        while (fast != null && fast.next != null) {
            fastTemp = fast.next;
            temp = slow.next;

            slow.next = prev;
            prev = slow;

            slow = temp;
            fast = fastTemp.next;
        }

        if (fast != null && fast.next == null) {
            slow = slow.next;
        }

        while (slow != null || prev != null) {
            if (slow == null || prev == null) {
                return false;
            }
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    public ListNode recover(ListNode head) {
        return reverse(head);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
