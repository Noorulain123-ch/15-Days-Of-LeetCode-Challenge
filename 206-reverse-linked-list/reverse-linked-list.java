class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;      // previous
        ListNode q = head;      // current

        while (q != null) {
            ListNode r = q.next;  // save next
            q.next = p;           // reverse link
            p = q;                // move p
            q = r;                // move q
        }

        return p;  // p becomes the new head
    }
}
