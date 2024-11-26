import java.util.ArrayList;
import java.util.Scanner;

class Library {
    private ArrayList<Book> books_array = new ArrayList<>(); // список книг

    public ArrayList<Book> getBooksArray() {
        return books_array;
    }


    public boolean addBook() {
        Book new_book = new Book();
        System.out.println("   Введите информацию о новой книге:");
        
        Scanner in = new Scanner(System.in);
        System.out.print("Название: "); new_book.setName(in.nextLine());
        System.out.print("Автор: "); new_book.setAuthor(in.nextLine());
        // Тут можно захерить исполнение :/, поэтому проверяем пользователя
        System.out.print("Год издания: "); 
        try {
        new_book.setYear(in.nextInt());
        } catch (Exception e) {
            System.out.println("!!! Год должен быть числом !!!");
            return false;
        }
        in.nextLine();
        System.out.print("Жанр: "); new_book.setGenre(in.nextLine());

        for (Book book : books_array) {
            if (book.equals(new_book)) {
                System.out.println("   !!! Книга уже есть !!!\n");
                return false;
            }
        }
        books_array.add(new_book);
        return true;
    }

    public boolean printBooksList() {
        if (books_array.isEmpty()) {
            System.out.println("   !!! Библиотека пуста !!!");
            return false;
        }

        System.out.println("   Информация о всех имеющихся книгах:");
        for (Book book : books_array) {
            System.out.println(book.getInfo());
        }
        
        return true;
    }

    public boolean deleteBook() {
        if (books_array.isEmpty()) {
            System.out.println("   !!! Библиотека пуста !!!");
            return false;
        }
        
        Scanner in = new Scanner(System.in);
        System.out.println("   Введите название книги:");
        String name = in.nextLine();

        this.books_array.removeIf(book -> (book.getName().equals(name)));
        
        return true;
    }
}