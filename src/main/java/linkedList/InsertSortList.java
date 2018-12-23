package linkedList;

public class InsertSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted

        while (cur != null) {
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }
}
