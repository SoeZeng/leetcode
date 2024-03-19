package daily_task;

/**
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
 * 包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 */
public class AreaAndSearch_303 {

}

class NumArray {

    /**
    int[] nums;
    int[] sums;

     public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = new int[n];
        this.sums = new int[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            this.nums[i] = nums[i];
            this.sums[i] = temp + nums[i];
            temp = sums[i];
        }
    }

    public int sumRange(int left, int right) {
        int res = 0;
        if(left >= 0 && right < this.nums.length) {
            res = this.sums[right] - this.sums[left] + this.nums[left];
        }
        return res;
    }
     **/

    int[] pre;

    public NumArray(int[] nums) {
        pre = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return pre[right + 1] - pre[left];
    }
}
