class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode temp = head;

        // Count length
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // If first node has to be removed
        if (length == n) {
            return head.next;
        }

        int pos = length - n;

        temp = head;

        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}