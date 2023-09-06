+ 基本思路（查找法和排除法是两种不同的思路）
    + 查找法
        + while (left <= right)
        + left 和 right的更新都是靠mid + - 1
        + 多一个nums[mid] == target的分支判断
        + while里面是 return mid，while外面是return -1，退出while的时候left和right不等
    + 排除法
        + 将待搜索区域分成两部分，一部分***一定不***包含目标，另一部分***可能***包含目标
        + 【核心】在写if和else语句的时候，总是思考当Nums[mid]满足什么条件时，Nums[mid]不是目标元素。所以叫排除法
        + while (left < right)
        + left 和 right的更新，有一个是靠mid + - 1，另一个是直接等于mid
        + 这样在退出循环的时候一定有：left==right。也就不用考虑是返回left还是返回right，返回哪个都一样。
        + return left
        + 先写分支逻辑，再决定中间数是否上取整：在使用多了以后，就很容易记住，只要看到 left = mid ，它对应的取中位数的取法一定是 int mid = left + (right - left + 1) / 2
+ 题型顺序
    + 查找法
        + 704
        + 33
        + 81
    + 排除法
        + 35
        + 34
        + 153
        + 154
        + 1095
    + 旋转数组 33、81、153（JZ11）、154
        + 一定有一半是有序的
        + nums[left] <= nums[mid] 代表左半部分有序。注意，这里有等于号
        + 就算 nums[mid] <= nums[right]，右半部分也不一定有序

