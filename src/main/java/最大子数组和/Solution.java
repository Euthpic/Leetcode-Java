package 最大子数组和;

//分治
public class Solution {
    private class Status {
        public int lsum;//左子区间最大和
        public int rsum;//右子区间最大和
        public int msum;//区间最大和
        public int isum;//区间和

        public Status(int lsum, int rsum, int msum, int isum) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.msum = msum;
            this.isum = isum;
        }
    }

    public int maxSubArray(int[] nums) {
        return getInfo(nums,0,nums.length-1).msum;
    }

    private Status getInfo(int[] nums, int l, int r) {
        if (l == r) {
            return new Status(nums[l], nums[l], nums[l], nums[l]);
        } else {
            int m = (l + r) / 2;
            Status lside = getInfo(nums, l, m);
            Status rside = getInfo(nums, m + 1, r);
            return pushUp(lside,rside);
        }
    }

    //区间回升 or 合并区间
    private Status pushUp(Status l, Status r) {
        int isum=l.isum+r.isum;
        int lsum=Math.max(l.lsum,l.isum+r.lsum);
        int rsum=Math.max(r.rsum,r.isum+l.rsum);
        int msum=Math.max(Math.max(l.msum,r.msum),l.rsum+r.lsum);
        return new Status(lsum,rsum,msum,isum);
    }
}
