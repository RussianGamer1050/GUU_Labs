
/*
 * Напишите рекурсивную функцию, 
 * которая получает аргумент — целое число n 
 * и возвращает In (n!).
 */

import java.util.Scanner;

public class task2 {
    public static int factorial(int n) {
        int result;

        if (n == 1)
            return 1;
        result = factorial(n - 1) * n;
        return result;
    }

    public static void main(String[] args) {
        // Ввод num
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = in.nextInt();
        in.close();

        System.out.println("Натуальный логарифм от факториала " + num + " равен: " + Math.log(factorial(num)));
    }
}
