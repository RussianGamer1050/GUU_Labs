
/*
 * Сколько строк выдает данная программ?
 */

public class task6 {

    public static void main(String[] args) {
        for (int i = 0; i < 999; i++); // т.к. здесь стоит ; оно выполнится
        { System.out.println("Hello"); } // и только потом выведется Hello
    }
}

/*
 * Таким образом "Hello" будет выведено 
 * всего 1 раз
*/
