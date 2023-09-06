+ 结合OneNote笔记复习
+ 复习顺序
    + 基本排序算法 912
       + 快排
            + 递归退出条件 start >= end
            + nums[start]是pivot
            + while (left <= right)
            + 左指针移动直到找到第一个比pivot大的
            + 右指针移动直到找到第一个比pivot小的
            + 交换左右
            + 退出while，交换start和right
            + 退出while后，left在right右边第一个
            + right位置的元素已经找到了数组完全排序后它最终应该在的位置
            + 对start 到 right - 1快排
            + 对left 到 end快排
       + 归并
            + 递归退出条件 start >= end
            + 左中右
            + merge的时候双指针比大小找位置
       + 堆排序
            + 用数组的index去模拟堆，左子是2*i+1，右子是2*i+2
            + 先整体建堆，i从一半到0
            + heapify的时候是和maxIndex比
            + 建完堆，把0挪到最后，因为在数组形成的大根堆中，nums[0]是最大值
            + 把最大值挪到数组的最后一个位置
            + heapSize--
            + 重新对0做heapify
    + TopK 问题 215
        + quickSelect
        + 堆排序
    + 数组中逆序对
        + 归并
        + 每次放左边的元素的时候，要看已经放了多少右边的元素，这就是所谓的逆序对
        + 使用索引数组解法的话，之前归并排序时nums[i]的地方就要换成indexes[i]，并不是真的对nums排序，而且在indexes数组中维护一个对nums排序的索引
        + 315
        + JZ51
    + 快排扩展
        + 三路快排（重复元素多，三指针） 75