class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == val) {
                prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}
