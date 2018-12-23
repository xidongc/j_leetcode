package linkedList;

import java.util.Arrays;

class TestLinkedListCommon {

    ListNode createList(int[] list){
        ListNode head = new ListNode(list[0]);
        ListNode tmp = head;
        for (int l: Arrays.copyOfRange(list, 1, list.length)){
            tmp.next = new ListNode(l);
            tmp = tmp.next;
        }
        return head;
    }

    void printHead(ListNode head, int maxRecursive){
        if (head == null){
            return;
        }
        ListNode tmp=head;
        while (tmp != null && maxRecursive >= 0){
            System.out.println(tmp.val);
            tmp = tmp.next;
            maxRecursive --;
        }
    }

    void printHead(ListNode head){
        this.printHead(head, Integer.MAX_VALUE);
    }
}
