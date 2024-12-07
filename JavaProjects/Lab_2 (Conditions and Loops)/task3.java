
/*
 * Напишите программу с одним циклом for и одной командой if, 
 * которая выводит целые числа от 1000 до 2000, по 5 чисел на строку.
 */

public class task3 {

    public static void main(String[] args) {
        for (int i = 1000; i < 2000; i++) {
                if ((i % 10 == 5) || (i % 10 == 0)) {
                    System.out.print("\n" + i + " ");
                }
                else {
                    System.out.print(i + " ");
                }
        }
    }
}
