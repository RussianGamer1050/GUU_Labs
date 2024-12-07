
/*
 * Дано слово, состоящее только из строчных латинских букв. 
 * Проверьте, является ли это слово палиндромом. Выведите YES или NO.
 * При решении этой задачи нельзя пользоваться циклами.
 */

import java.util.Scanner;

public class task4 {

    // Функция, которая получает строку и возвращает перевернутую
    public static String reverseString(String str) {
        String rightStr;
        String leftStr;
        int length = str.length();
      
        if (length <= 1) {
           return str;
        }
      
        leftStr = str.substring(0, length / 2);
        rightStr = str.substring(length / 2, length);
      
        return reverseString(rightStr) + reverseString(leftStr);
      }


    public static void main(String[] args) {
        String word;
        int is_lenght_even;
        
        Scanner in = new Scanner(System.in);

        System.out.println("Введите слово: ");
        word = in.nextLine();
        word = word.toLowerCase();

        in.close();

        // Длина слова = слово - конечный символ [w, o, r, d, \n] = 5 - 1
        int word_lenght = word.length() - 1;
        
        // Проверяем, четное ли число букв в слове
        if (word_lenght % 2 != 0) {
            is_lenght_even = 0;
        }
        else {
            is_lenght_even = 1;
        }

        // Разделение слово на 2 части
        String part_1 = word.substring(0, word_lenght / 2);
        // Находим вторую часть, убрав или оставив центральную букву
        String part_2 = word.substring((word_lenght / 2) + is_lenght_even);
        part_2 = reverseString(part_2);

        // Если использовать part_1 == part_2 ничего не получится, т. к. == сравнивает ссылки
        if (part_1.equals(part_2)) { // чтобы понять, почему некорректно работает ушло 30 минут времени ._.
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
