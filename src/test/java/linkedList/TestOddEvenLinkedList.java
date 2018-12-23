package linkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestOddEvenLinkedList {

    @Test
    public void test(){
        OddEvenLinkedList oll = new OddEvenLinkedList();
        TestLinkedListCommon common = new TestLinkedListCommon();
        int[] list = new int[]{1, 2, 3, 4, 5};
        ListNode head = common.createList(list);
        common.printHead(head);
        ListNode newHead = oll.oddEvenList(head);
        common.printHead(newHead);
    }
}
