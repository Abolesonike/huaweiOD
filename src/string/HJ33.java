package string;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * <b>HJ33 整数与IP地址间的转换</b>
 * <p></p>
 *
 * 描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * <p>
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * <p>
 * 数据范围：保证输入的是合法的 IP 序列
 * <p>
 * 输入描述：
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * <p>
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * <p> <p>
 * 示例1 <p>
 * 输入： <p>
 * 10.0.3.193 <p>
 * 167969729
 * <p>
 * 输出： <p>
 * 167773121 <p>
 * 10.3.3.193
 */
public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine().toLowerCase();
            boolean isIPAddress = line.contains(".");
            if (isIPAddress) {
                System.out.println(IP2Number(line));
            } else {
                System.out.println(number2IP(line));
            }
        }
    }

    private static long IP2Number(String iPAddress) {
        StringBuilder number = new StringBuilder();
        String[] split = iPAddress.split("\\.");
        for (String s : split) {
            // 十进制转二进制
            StringBuilder i = new StringBuilder(Long.toBinaryString(Long.parseLong(s)));
            while (i.length() < 8) {
                i.insert(0, "0");  // 拼接
            }
            // 转字符
            number.append(i);
        }
        // 再转十进制
        return Long.parseLong(number.toString(), 2);
    }

    private static String number2IP(String number) {
        StringJoiner iPAddress = new StringJoiner(".");
        // 转二进制
        StringBuilder binaryString = new StringBuilder(Long.toBinaryString(Long.parseLong(number)));
        while (binaryString.length() < 32) {
            binaryString.insert(0, "0");
        }
        String  binary = binaryString.toString();
        // 拆分
        for (int i = 0; i < 4; i++) {
            iPAddress.add(String.valueOf(Integer.parseInt(binary.substring(0, 8), 2)));
            binary = binary.substring(8);
        }
        return iPAddress.toString();
    }
}
