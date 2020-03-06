package BestTasks;

import java.util.Scanner;
/**
 * Заполняет цыфры по спирали
 * */
public class SnackInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        do {
            System.out.print("Введите длину стороны Х (минимум 2): ");
            x = scanner.nextInt();
            System.out.print("Введите длину стороны Y (минимум 2): ");
            y = scanner.nextInt();
        } while (x < 1 || y < 1);
        int[][] array = new int[x][y];
        int[] arrayMask = {1, 1, -1, -1};
        int indexMask = 0;
        int count = 0;
        int aNext = 0;
        int bNext = 0;
        int aCurrent = 0;
        int bCurrent = 0;
        do {
            do {
                if (0 <= aNext && aNext < x && 0 <= bNext && bNext < y && array[aNext][bNext] == 0) {
                    aCurrent = aNext;
                    bCurrent = bNext;
                } else {
                    if (++indexMask == 4) {
                        indexMask = 0;
                    }
                    aCurrent += indexMask % 2 == 0 ? 0 : arrayMask[indexMask];
                    bCurrent += indexMask % 2 == 0 ? arrayMask[indexMask] : 0;
                }
                bNext = bCurrent + (indexMask % 2 == 0 ? arrayMask[indexMask] : 0);
                aNext = aCurrent + (indexMask % 2 == 0 ? 0 : arrayMask[indexMask]);
                array[aCurrent][bCurrent] = ++count;
            } while (0 <= aNext && aNext < x && 0 <= bNext && bNext < y && array[aNext][bNext] == 0);
        } while (count < x * y);

        for (int[] ints : array) {
            System.out.println("");
            for (int anInt : ints) {
                System.out.print(anInt + ", ");
            }
        }
    }
}
