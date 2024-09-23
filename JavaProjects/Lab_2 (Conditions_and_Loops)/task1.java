
/*
 * Напишите программу, которая получает три целых числа 
 * как аргументы командной строки и выводит сообщение "equal", 
 * если все три числа равны, или "not equal" в противном случае.
 */

import java.util.Scanner;

public class task1 {

    public static void main(String[] args) {
        int num1, num2, num3;

        Scanner in = new Scanner(System.in);
        
        System.out.println("Последовательно введите три числа: ");
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();

        in.close();

        // Сравнение чисел
        if ((num1 == num2) && (num2 == num3)) {
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }
    }
}
