
/*
 * Дан массив целых чисел и ещё одно целое число. 
 * Удалите все вхождения этого числа из массива 
 * (пропусков быть не должно).
*/

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Количество элементов массива
        System.out.println("Введите количество элементов в массиве: ");
        int array_length = in.nextInt();

        int[] num_array = new int[array_length]; // выделение памяти под массив
        
        // Заполнение массива
        System.out.println("Введите числа в массив: ");
        for (int i = 0; i < array_length; i++) {
            num_array[i] = in.nextInt();
        }

        // Целое число
        System.out.println("Введите целое число: ");
        int num = in.nextInt();

        in.close();

        // Нахождение количества встречаемых в массиве "num"
        int k = 0; // счётчик количества "num" в массиве
        for (int i = 0; i < array_length; i++) {
            if (num_array[i] == num) k++;
        }

        // Создание нового массива, в котором отсутствует "num"
        int new_array_lenght = array_length - k;
        int[] new_num_array = new int[new_array_lenght];
        int j = 0; // индексы нового массива
        for (int i = 0; i < array_length; i++) {
            if (num_array[i] != num) new_num_array[j++] = num_array[i];
        }

        // Вывод нового массива
        System.out.print("[ ");
        for (int i = 0; i < (new_array_lenght); i++) {
            System.out.print(new_num_array[i] + " ");
        }
        System.out.print("]");
    }
}
