package Microsoft.q4_寻找两个正序数组的中位数;


/*

解题思路：二分法

此题求两个有序数组的中位数，并且限制时间复杂度为O(log (m+n))，所以自然想到要用二分法求解。

中位数：如果某个有序数组长度是奇数，那么其中位数就是最中间那个，如果是偶数，那么就是最中间两个数字的平均值。这里对于两个有序数组也是一样的，
假设两个有序数组的长度分别为m和n，由于两个数组长度之和m+n的奇偶不确定，因此需要分情况来讨论，对于奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。

使用一个小trick，可以避免讨论奇偶：
我们分别找第 (m+n+1)/2个数，和(m+n+2)/2个数，然后求其平均值即可，这对奇偶数均适用。假如 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，
相当于两个相同的数字相加再除以2，还是其本身。

那么接下来重点就变成如何在两个有序数组中找到第K个（第k小的）元素。
首先，为了避免产生新的数组从而增加时间复杂度，我们使用两个变量 i 和 j 分别来标记数组nums1和nums2的起始位置。

递归出口：
当K=1时候，相当于求最小值，我们只要比较nums1和nums2的起始位置i和j上的数字就可以了。

一般情况：
取两个数组中的第k/2个元素（midVal1和midVal2）进行比较，如果midVal1 < midVal2，则说明数组1中的前k/2个元素不可能成为第k个元素的候选，
所以将数组1中的前k/2个元素去掉，作为新数组和数组2求第k-k/2小的元素，因为我们把前k/2个元素去掉了，所以相应的k值也应该减少k/2。midVal1 > midVal2的情况亦然。

边界问题：

当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。

由于两个数组的长度不定，所以有可能某个数组元素数不足k/2，所以我们需要先检查一下，数组中到底存不存在第K/2个数字，如果存在就取出来，否则就赋值上一个整型最大值，
这样肯定会大于另一个数组的第k/2个元素，从而把另一个数组的前k/2个元素淘汰。

ps：赋予整型最大值的意思只是说如果第一个数组的K/2不存在，则说明这个数组的长度小于K/2，那么另外一个数组的前K/2个我们是肯定不要的。例如，加入第一个数组长度是2，
第二个数组长度是12，则K为7，K/2为3，因为第一个数组长度小于3，则无法判断中位数是否在其中，而第二个数组的前3个肯定不是中位数！


 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if( nums1 == null || nums2 == null || nums1.length < 0 || nums2.length <0) return 0.0;
        // 利用二分法查找
        // 利用一个小方法，使得如果是奇数得到的索引是也是一样的 (m+n+1)/2,(m+n+2)/2;
        // 假如奇数的情况: n=3,m=4，那么l=4,r=4。
        // 实际上可以理解求中间索引，是往前移动了0.5，因为是整数正好没有影响。
        // 例如偶数的情况：n=4,m=4，那么l=4.5,r=5。原来方法的计算值是l=4,r=4.5
        int m = nums1.length;
        int n = nums2.length;
        int l = (m+n+1)/2;
        int r = (m+n+2)/2;

        return (findMid(nums1, 0, nums2,0, l) + findMid(nums1, 0, nums2,0, r))/2.0;

    }

    public double findMid(int[] a, int startA, int[] b, int startB, int k){
        // 如果当前的开始值已经大于数组的长度，那么中位数的索引一定在另一个数组里面。
        if(startA > a.length-1) return b[startB+k-1];
        if(startB > b.length-1) return a[startA+k-1];

        // 终止条件，当索引值为1时，证明当前两个数组合并后的最小值就是该位置
        if(k == 1) return Math.min(a[startA], b[startB]);

        int midA = startA + k/2 -1 < a.length ? a[startA + k/2 -1] : Integer.MAX_VALUE;
        int midB = startB + k/2 -1 < b.length ? b[startB + k/2 -1] : Integer.MAX_VALUE;

        // 谁的中位值小，就删除它的前k/2的值。
        if( midA < midB ) {
            return findMid(a, startA+ k/2, b , startB , k-k/2);
        } else {
            return findMid(a, startA , b , startB+ k/2 , k-k/2);
        }

    }
}
