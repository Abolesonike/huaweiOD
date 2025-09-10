package C2025;

import java.util.Scanner;

/**
 * 经典屏保
 * https://sars2025.blog.csdn.net/article/details/139638078
 */
public class OD391 {
    public static void main(String[] mian) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int time = scanner.nextInt();
        scanner.close();
        String dir = "3";

        for (int i = 0; i < time ; i ++) {
            dir = changeDir(x, y, dir);
            switch (dir) {
                case "1":
                    x--;
                    y--;
                    break;
                case "2":
                    x++;
                    y--;
                    break;
                case "3":
                    x++;
                    y++;
                    break;
                case "4":
                    x--;
                    y++;
                    break;
            }
        }
        System.out.println(x + " " + y);

    }

    public static String changeDir (int x, int y, String dir) {
        if (x == 0 && y == 0) {
            return "3";
        }
        if (x == 0 && y == 575) {
            return "2";
        }
        if (x == 750 && y == 0) {
            return "4";
        }
        if (x == 750 && y == 575) {
            return "1";
        }
        if (x == 0) {
            if (dir == "4") {
                return "3";
            } else {
                return "2";
            }
        }
        if (x == 750) {
            if (dir == "3") {
                return "4";
            } else {
                return "1";
            }
        }
        if (y == 0) {
            if (dir == "1") {
                return "4";
            } else {
                return "3";
            }
        }
        if (y == 575) {
            if (dir == "3") {
                return "2";
            } else {
                return "1";
            }
        }
        return dir;
    }

}
