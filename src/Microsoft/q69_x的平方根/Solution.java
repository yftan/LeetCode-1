package Microsoft.q69_x的平方根;

class Solution {
    public static int mySqrt(int x) {
        int l=0;
        int r=x;

        while(l<=r){
            int mid = l + (r-l)/2;
            if((long)mid*mid > x){
                r =  mid-1;
            } else if((long)mid*mid < x){
                l = mid+1;
            } else {
                return (int)mid;
            }
        }
        return l-1;
    }

    public static void main(String[] args) {
        mySqrt(2147395599);
    }
}