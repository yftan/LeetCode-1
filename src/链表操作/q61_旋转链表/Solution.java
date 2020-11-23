package 链表操作.q61_旋转链表;

/**
 * 先连接成环再找断点 o(n)
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode oldTail = head;
        int n;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;
        ListNode newTail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if(head == null) return null;
        // 取余，计算链表的长度。
        int len = 0;
        ListNode count =  head;
        while(count!=null){
            len++;
            count = count.next;
        }
        k = k%len;
        //=======
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        while( k > 0) {
            // find the end of list, and the prev of end
            ListNode prev = dummyHead;
            ListNode curr = prev.next;
            while(curr.next!=null){
                curr = curr.next;
                prev = prev.next;
            }
            prev.next = curr.next;
            curr.next = dummyHead.next;
            dummyHead.next =curr;
            k--;
        }
        return dummyHead.next;
    }
}
