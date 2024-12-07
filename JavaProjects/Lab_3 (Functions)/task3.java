
/*
 * Дано натуральное число n>1. Проверьте, является ли оно простым. 
 * Программа должна вывести слово YES, если число простое и NO, 
 * если число составное. 
 * Алгоритм должен иметь сложность O(logn).
*/

import java.util.Scanner;

public class task3 {
    /*
     * Чтобы добиться необходимой скорости воспользуюсь статьей
     * https://habr.com/ru/articles/205318/
    */

    // Нахождение НОД
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    // Алгоритм проверки на простоту Ферма
    public static boolean ferma(int n) {
        if (n == 2)
            return true;
        
        for (int i = 0; i < 100; i++) {
            int a = ((int)(Math.random() * 1000) % (n - 2)) + 2;
    
            if (gcd(a, n) != 1)
            return false;
        }

        return true;
    }

    // Алгорит проверки на простоту выдуманный из головы
    public static boolean improvised(int n) {
        if (n == 2)
            return true;

        // Создаем массив чисел (1; n)
        int[] num_array = new int[n - 2];
        for (int i = 2; i < n; i++) {
            num_array[i - 2] = i;
        }

        // Проверяем, является ли число простым
        for (int i = 0; i < num_array.length - 1; i++) {
            if (gcd(num_array[i], n) != 1)
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Проверка ввода
        int num;
        do {
            System.out.println("Введите число n > 1");
            num = in.nextInt();
        } while (num <= 1);
        
        in.close();

        if (ferma(num)) {
            System.out.println("YES"); // [1]
        }
        else System.out.println("NO");
        if (improvised(num)) {
            System.out.println("YES"); // [2]
        }
        else System.out.println("NO");
    }
}

/*
 * Итоговая скорость [1]: O(K * log N),
 * где K - количество итераций теста Ферма,
 * в данном решении K = 100
*/

/*
 * Итоговая скорость [2]: **я не умею определять скорость** :/
 * но по ощущениям, если число больше 102, то первый вариант будет
 * быстрее, т. к. в [2] количество итераций будет больше 100, а
 * в случае [1] всегда 100, независимо от n
*/
