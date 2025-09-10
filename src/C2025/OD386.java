package C2025;

import java.util.Scanner;

/**
 * 给一个数组，判断山峰的个数，数组的每个元素的值代表海拔高度，0代表平地，数值越高，海拔越高，山峰的定义为当某个位置左右的海拔低于自己的海拔的时候，这个位置就是山峰，数组的起始和末尾如果符合条件也算山峰
 *
 * <p>
 * 输入<br>
 * 一个整数数组<br>
 *
 * 输出<br>
 * 符合条件的山峰个数
 * </p>
 *
 * --样例1--
 * 输入
 * 0,1,2,3,2,4
 *
 * 输出
 * 2
 *
 * --样例1--
 * 输入
 * 3,0,3,4,1
 *
 * 输出
 * 2
 * ----
 */

/**
 * AC 10/10
 */
public class OD386 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            System.out.println(0);
            return;
        }
        String nums[] = line.split(",");
        if (nums.length == 0) {
            System.out.println(0);
            return;
        }
        if (nums.length == 1) {
            if (Integer.parseInt(nums[0]) > 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }


        int result = 0;
        // 开头和结尾
        if (Integer.parseInt(nums[0]) > Integer.parseInt(nums[1])) {
            result ++;
        }
        if (Integer.parseInt(nums[nums.length - 1]) > Integer.parseInt(nums[nums.length - 2])) {
            result ++;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (Integer.parseInt(nums[i]) > Integer.parseInt(nums[i-1])
                    && Integer.parseInt(nums[i]) > Integer.parseInt(nums[i+1])) {
                result ++;
            }
        }
        System.out.println(result);
    }
}
