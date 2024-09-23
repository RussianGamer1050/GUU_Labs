
/*
 * Медиана 5 чисел. 
 * Напишите программу, которая получает в аргументах
 * командной строки пять разных целых чисел и выводит их медиану (то из этих
 * чисел, которое меньше двух из оставшихся четырех и больше других двух из них).
 * 
 * Задание повышенной сложности: решите задачу при помощи программы, которая
 * сравнивает значения менее 7 раз для любого заданного ввода.
 */

 import java.util.Scanner;
 import java.util.Arrays; // простой способ сортировки массива

 public class task10 {
 
    public static void main(String[] args) {
        // При решении с использованием массива можно избежать инициализацию 5 переменных
        int num1, num2, num3, num4, num5; // но я решу и так и так
        
        Scanner in = new Scanner(System.in);

        System.out.println("Введите последовательно 5 разных целых чисел: ");
        num1 = in.nextInt(); num2 = in.nextInt(); num3 = in.nextInt();
        num4 = in.nextInt(); num5 = in.nextInt();

        in.close();

        // Способ 1 - простой, через массив
        /*
         * Т. к. медиана - число меньше двух и больше двух, 
         * то в данном случае в отсортированном массиве это 3-тий элемент.
         */
        int[] array1 = {num1, num2, num3, num4, num5};
        Arrays.sort(array1);
        System.out.println(array1[2]);

        // Способ 2 - через if'ы (нет)
        /*
         * Ни сам не смог придумать, ни в интернете ничего толкового не нашел.
         * Везде находят через отсортированный список, поэтому вторым методом 
         * просто самостоятельно отсортирую массив и возьму медиану.
         */
        // Для пяти элементов подойдет и шейкерный метод сортировки
        int[] array2 = {num1, num2, num3, num4, num5};
        int right_side = array2.length - 1, left_side = 0;
        
        do {

            for (int i = left_side; i < right_side; i++) {
                if (array2[i] > array2[i + 1]) {
                    int temp = array2[i];
                    array2[i] = array2[i + 1];
                    array2[i + 1] = temp;
                }
            }

            right_side--;

            for (int i = right_side; i > left_side; i--) {
                if (array2[i] < array2[i - 1]) {
                    int temp = array2[i];
                    array2[i] = array2[i - 1];
                    array2[i - 1] = temp;
                }
            }

            left_side++;

        } while (left_side < right_side);

        System.out.println(array2[2]);
    }
 }
