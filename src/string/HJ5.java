package string;

import java.util.Scanner;

/**
 * <b>HJ5 进制转换</b><p></p>
 *
 * 描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * <p>
 * 输入描述：
 * 输入一个十六进制的数值字符串。
 * <p>
 * 输出描述：
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String number = line.substring(2).toLowerCase();
        char[] charArray = number.toCharArray();
        int result = 0;
        for (int i = 0; i < charArray.length; i++) {
            int num = 0;
            if (Character.isLetter(charArray[i])) {
                num = charArray[i] - 'a' + 10;
            } else {
                num = charArray[i] - '0';
            }
            result += (int) (Math.pow(16, Math.abs(i -  charArray.length + 1)) * num);
        }
        System.out.println(result);
    }
}
