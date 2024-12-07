
/*
 * Напишите фрагмент кода, который выводит сообщение "true", 
 * если переменные х и у типа double лежат строго в диапазоне 
 * от 0 до 1, или "false" в противном случае.
*/

import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        double x, y;

        Scanner in = new Scanner(System.in);

        System.out.println("Введите x и y: ");
        x = in.nextDouble();
        y = in.nextDouble();

        in.close();

        // Проверка диапазона от 0 до 1
        if (((x < 1) && (x > 0)) && ((y < 1) && (y > 0))) {
            System.out.println("true");
        }
        else {
            System.out.println("false");;
        }
    }
}
