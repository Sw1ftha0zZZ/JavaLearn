package algorithm.binarySearch.book;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/10/30
 */

public class JZOffer11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;

            //中间比右边小，说明右半部分一定不是
            if (numbers[mid] < numbers[right]) {
                right = mid;
            }else if (numbers[mid] > numbers[right]) {
                //中间比右边大，说明一定旋转了，而且左边一定不是
                left = mid + 1;
            }else {
                right--;
            }
        }
        return numbers[left];
    }
}
