package 双指针遍历.q142_环形链表_II;


import java.util.HashSet;
import java.util.Set;

/**
 解题思路：
 这类链表题目一般都是使用双指针法解决的，例如寻找距离尾部第K个节点、寻找环入口、寻找公共尾部入口等。
 算法流程：
 双指针第一次相遇： 设两指针 fast，slow 指向链表头部 head，fast 每轮走 2 步，slow 每轮走 1 步；

 第一种结果： fast 指针走过链表末端，说明链表无环，直接返回 null；

    TIPS: 若有环，两指针一定会相遇。因为每走 1 轮，fast 与 slow 的间距 +1，fast 终会追上 slow；
 第二种结果： 当fast == slow时， 两指针在环中 第一次相遇 。下面分析此时fast 与 slow走过的 步数关系 ：

     设链表共有 a+b 个节点，其中 链表头部到链表入口 有 aa个节点（不计链表入口节点）， 链表环 有 b 个节点（这里需要注意，a 和 b是未知数，例如图解上链表 a=4, b=5）；设两指针分别走了 f，s 步，则有：
     fast 走的步数是slow步数的 2 倍，即 f = 2s；（解析： fast 每轮走 2 步）
     fast 比 slow多走了 n 个环的长度，即 f = s + nb；（ 解析： 双指针都走过 aa 步，然后在环内绕圈直到重合，重合时 fast 比 slow 多走 环的长度整数倍 ）；
     以上两式相减得：f = 2nb，s = nb，即fast和slow 指针分别走了 2n，n 个 环的周长 （注意： n 是未知数，不同链表的情况不同）。
     目前情况分析：

 如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是：k=a+nb（先走 a 步到入口节点，之后每绕 1 圈环（ b 步）都会再次到入口节点）。
 而目前，slow 指针走过的步数为 nb 步。因此，我们只要想办法让 slow 再走 a 步停下来，就可以到环的入口。
 但是我们不知道 a 的值，该怎么办？依然是使用双指针法。我们构建一个指针，此指针需要有以下性质：此指针和slow 一起向前走 a 步后，两者在入口节点重合。那么从哪里走到入口节点需要 a 步？答案是链表头部head。
 双指针第二次相遇：

     slow指针 位置不变 ，将fast指针重新 指向链表头部节点 ；slow和fast同时每轮向前走 11 步；
     TIPS：此时 f = 0，s = nb ；
     当 fast 指针走到f = a 步时，slow 指针走到步s = a+nb，此时 两指针重合，并同时指向链表环入口 。
     返回slow指针指向的节点。

 复杂度分析：
 时间复杂度 O(N) ：第二次相遇中，慢指针须走步数 a < a + b；第一次相遇中，慢指针须走步数 a + b - x < a + b，其中 x 为双指针重合点与环入口距离；因此总体为线性复杂度；
 空间复杂度 O(1) ：双指针使用常数大小的额外空间。

 */
public class Solution {
    /**
     * 暴力解法
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head!= null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return head;
    }

    public ListNode detectCycle1(ListNode head) {
        if(head == null) return null;
        ListNode slow = head.next;
        if(slow == null) return null;
        ListNode fast = head.next.next;
        if(fast == null) return null;
        if(slow == fast) return slow;
        // 第一次相遇
        while( slow != fast) {
            if(fast ==null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 构建第二次相遇,借助第三个Node或者复用Fast都可以，但是这次要一步一步走，走a步正好相遇
        ListNode third = head;
        while(third != slow) {
            slow = slow.next;
            third = third.next;
        }
        return slow;
    }
}
