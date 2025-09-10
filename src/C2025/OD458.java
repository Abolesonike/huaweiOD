package C2025;


import java.util.Scanner;

/**
 * OD458. 堆内存申请
 * 有一个总空间为100字节的堆，现要从中新申请一块内存，内存分配原则为优先紧接着前一块已使用内存分配空间足够且最接近申请大小的空闲内存。
 *
 * <p>输入<br>
 * 第1行是1个整数，表示期望申请的内存字节数；
 * 第2到N行是用空格分割的两个整数，表示当前已分配的内存的情况，每一行表示一块已分配的连续内存空间，每行的第1和第2个整数分别表示偏移地址和内存块大小，如：
 *  0 1
 *  3 2
 *  表示0偏移地址开始的1个字节和3偏移地址开始的2个字节已被分配，其余内存空闲
 *  输出
 *  若申请成功，输出申请到内存的偏移；若申请失败，输出-1
 *
 *  补充说明:
 *  1、若输入信息不合法或无效，则申请失败
 *  2、若没有足够的空间供分配，则申请失败
 *  3、堆内存信息有区域重叠或有非法值等都是无效输入
 *
 */

/**
 * AC 9/10
 */
public class OD458 {
    public static void main(String[] args) {
        int[] memory = new int[100];
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int offset = Integer.parseInt(input.split(" ")[0]);
            int space = Integer.parseInt(input.split(" ")[1]);
            for (int i = 0; i < space; i++) {
                if (offset + i > 99) {
                    System.out.println(-1);
                    return;
                }
                memory[offset + i] = 1;
            }
        }
        boolean okIndex = false;
        int okSize = 0;
        int okBegin = -1;
        for (int i = 0; i < 100; i++) {
            if (!okIndex) {
                if (memory[i] == 0) {
                    okIndex = true;
                    okBegin = i;
                }
            } else {
                if (memory[i] == 1) {
                    okBegin = -1;
                    okIndex = false;
                    okSize = 0;
                }
                okSize += 1;
                if (okSize >= size) {
                    System.out.println(okBegin);
                    return;
                }
            }
        }
    }
}
