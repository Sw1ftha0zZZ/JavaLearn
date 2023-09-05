+ 基本思路
    + 查找元素的时候 while (left <= right)
    + 排除元素的时候 while (left < right)
    + 先写分支逻辑，再决定中间数是否上取整：在使用多了以后，就很容易记住，只要看到 left = mid ，它对应的取中位数的取法一定是 int mid = left + (right - left + 1) / 2
+ 题型顺序
    + 704
    + 35
    + 34
    + 33
    + 81
    + 153
    + 154

