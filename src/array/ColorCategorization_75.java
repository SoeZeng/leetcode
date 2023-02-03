package array;

public class ColorCategorization_75 {

}

class Solution75 {

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums，原地对它们进行排序，
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *
     * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
//        int[] counts = new int[3];
//
//        for(int num : nums) {
//            counts[num]++;
//        }
//
//        int index = 0;
//        for(int i = 0; i < counts.length; i++) {
//            int cnt = 0;
//            while(cnt++ < counts[i]) {
//                nums[index++] = i;
//            }
//        }

        // 遍历一趟
        int num0 = 0, num1 = 0, num2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            }else if(nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            }else {
                nums[num2++] = 2;
            }
        }
    }
}
