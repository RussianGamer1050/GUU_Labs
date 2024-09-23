
/*
 * Напишите программу, которая получает целое число n как аргумент
 * командной строки и выводит все положительные степени 2, меньшие или равные n.
*/

import java.util.Scanner;

public class task7 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        System.out.println("Введите целое число: ");
        int n = in.nextInt();
        
        in.close();

        if (n > 1) {
            int power_of_2 = 2; // начальная положительная степень двойки
            for (int i = 2; power_of_2 <= n; i++) {
                System.out.print(power_of_2 + " ");
                power_of_2 = (int)Math.pow(2, i);
            }
        }
        else {
            System.out.println("Нет положительных степеней 2, \nкоторые меньше " + n);
        }
    }
}
