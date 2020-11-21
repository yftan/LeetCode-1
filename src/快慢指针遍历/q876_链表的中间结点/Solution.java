package 快慢指针遍历.q876_链表的中间结点;

/**
 * 快慢指针法 o(n)
 */
public class Solution {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 利用一个虚拟节点
    public ListNode middleNode1(ListNode head) {
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            } else {
                return slow;
            }
        }
        return slow;
    }
}
