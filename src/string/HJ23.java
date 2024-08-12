package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * <b>HJ23 删除字符串中出现次数最少的字符</b>
 * <p>
 * 描述
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * <p>数据范围：输入的字符串长度满足
 * 1≤n≤20  ，保证输入的字符串中仅出现小写字母
 * <p>
 * 输入描述：
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * <p>
 * 输出描述：
 * 删除字符串中出现次数最少的字符后的字符串。
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String line = in.nextLine().toLowerCase();
            Map<Character, Integer> countMap = new HashMap<>();
            Set<Integer> count = new TreeSet<>();

            // 转为为map key:字符，value:次数
            for (char c : line.toCharArray()) {
                int num = countMap.get(c) == null ? 0 : countMap.get(c);
                countMap.put(c, num + 1);
            }
            // 收集数量，并排序
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                count.add(entry.getValue());
            }
            int min = (Integer) count.toArray()[0];
            // 替换次数最少的字符
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                if (min == entry.getValue()) {
                    line = line.replaceAll(String.valueOf(entry.getKey()), "");
                }
            }
            System.out.println(line);
        }
    }
}
