/*
 * Напишите программу, которая выводит в консоль 
 * такой рисунок:
 * 
 *     * * * * *
 *      * * * *
 *       * * *
 *        * *
 *         *
 *        * *
 *       * * *
 *      * * * *
 *     * * * * *
*/

public class task9 {

    public static void main(String[] args) {
        String s = " ", d = "* ";

        for (int i = 5; i < 9;) { // 5 пробелов изначально
            int j = 10 - i; // (10 - 5) звезд изначально
            
            System.out.print(s.repeat(i++)); // " " i-раз
            System.out.print(d.repeat(j--)); // "* " j-раз
            
            System.out.println();
        }
        
        for (int i = 9; i > 4;) { // 9 пробелов изначально
            int j = 10 - i; // (10 - 9) звезд изначально
            
            System.out.print(s.repeat(i--)); // " " i-раз
            System.out.print(d.repeat(j++)); // "* " j-раз
            
            System.out.println();
        }
    }
}
