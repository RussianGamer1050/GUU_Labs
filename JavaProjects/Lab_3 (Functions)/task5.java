
/*
 * Функция Аккермана A(m,n), играет важную роль 
 * в теории вычислимости. 
 * Она определена следующим образом:
 *            / n + 1,                  m = 0;
 * A(m, n) = *  A(m - 1, 1),            m > 0, n = 0;
 *            \ A(m - 1, A(m, n - 1));  m > 0, n > 0.
 * Условие задачи: есть 2 целых неотрицательных числа m и n, 
 * каждое из них находится в отдельной строке. Необходимо вывести A(m,n).
 */

import java.util.Scanner;

 public class task5 {
    public static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        }
        else if ((m > 0) && (n == 0)) {
            return ackermann(m - 1, 1);
        }
        else {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }    

    public static void main(String[] args) {
        int m, n;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Введите неотрицательное число m: ");
            m = in.nextInt();
        } while (m < 0);
        
        do {
            System.out.println("Введите неотрицательное число n: ");
            n = in.nextInt();
        } while (n < 0);

        in.close();

        System.out.println(ackermann(m, n));

    }
 }
