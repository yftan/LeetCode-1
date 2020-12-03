package Microsoft.q328_奇偶链表;


public class Solution {
    /**
     * 这题主要思路就是奇数链表一个头，偶数链表一个头，最后合并即可，
     * 创建头空间是O(1)
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        // 注意此处的判断，如果even.next也不用继续进行下去了
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode t = head;
        for (int i = 2; i <= 5; i++) {
            t.next = new ListNode(i);
            t = t.next;
        }
        new Solution().oddEvenList(head);
    }
}
