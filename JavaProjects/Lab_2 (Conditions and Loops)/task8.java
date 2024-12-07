
/*
 * Напишите фрагмент кода, который преобразует 
 * положительное целое число n в переменную s типа String.
 */

import java.util.Scanner;

public class task8 {

    public static void main(String[] args) {
        int n;
        String s = "";

        Scanner in = new Scanner(System.in);

        System.out.println("Введите положительное целое число: ");
        n = in.nextInt();

        in.close();

        // Определние длинны n
        int temp = n;
        int k = 0; // счетчик количества разрядов n
        while (temp != 0) {
            temp /= 10;
            k++;
        }

        // Преобразование int n в String s
        temp = n;
        int[] temp_array = new int[k];

        for (int i = k - 1; i >= 0; i--) { // заполнение массива в обратном порядке
            temp_array[i] = temp % 10;
            temp /= 10;
        }
        
        for (int i = 0; i < k; i++) { // заполнение s
            s += temp_array[i];
        }

        System.out.println(s);


    }
}

/*
 * Скорее всего можно сделать всё совершенно по другому,
 * но это по моему мнению самый банальный способ
 */
