
/*
 * Напишите программу, которая получает целое число n 
 * как аргумент командной строки, использует Math.random() 
 * для вывода п случайных значений в интервале от 0 до 1, 
 * после чего выводит их среднее значение.
 */

import java.util.Scanner;

public class task4 {
    
    public static void main(String[] args) {
    double sum = 0; // сумма случайных чисел

    Scanner in = new Scanner(System.in);
    
    System.out.println("Введите n: ");
    int n = in.nextInt();
    
    in.close();

    // Суммирование n случайных чисел
    for (int i = 0; i < n; i++) {
        double random_number = Math.random();
        sum += random_number;
        System.out.println(random_number);
    }

    double average = sum / n;
    
    System.out.println("Среднее значение " + n + " случайных чисел: " + average);
    }
}
