import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        LibraryFileManager lib = new LibraryFileManager();
        lib.createLibFile();
        
        Scanner in = new Scanner(System.in);
        int i; // вводимый пользователем вариант

        
        System.out.println("Добро пожаловать в библиотеку!");
        do {
            // User-интерфейс
            System.out.println("Выберите действие:");
            System.out.println(
            "1. Добавить книгу\n" + 
            "2. Просмотреть книги\n" +
            "3. Удалить книгу\n" +
            "4. Выход\n"
            );
            // Выбор действия пользователем
            do {
                System.out.println("Введите номер действия:");
                if (in.hasNextInt()) {
                    i = in.nextInt();
                    break;
                }
                else {
                    System.out.println("   !!! Введите НОМЕР действия !!!");
                }
                in.nextLine();
            } while(true);

            if (i != 4) {
                System.out.println("\n---------------------------------------------------\n");
            }

            switch (i) {
                case 1:
                    lib.addBookToFile();
                    break;
                case 2:
                    lib.printBooksList();
                    break;
                case 3:
                    lib.deleteBookFromFile();
                    break;
                case 4:
                    break;
            
                default:
                    System.out.println("   !!! Введен некорректный вариант !!!");
                    break;
            }
            if (i != 4) {
                System.out.println("\n---------------------------------------------------\n");
            }
        } while (i != 4);
        
        in.close();
    }
}
