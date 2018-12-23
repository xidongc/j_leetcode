package linkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestInsertSortList {

    @Test
    public void test(){
        InsertSortList isl = new InsertSortList();
        TestLinkedListCommon common = new TestLinkedListCommon();
        ListNode head = common.createList(new int[]{1,4,3,2,5});
        common.printHead(head);
        ListNode newHead = isl.insertionSortList(head);
        common.printHead(newHead,5);
    }
}
