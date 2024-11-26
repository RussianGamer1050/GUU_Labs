import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class LibraryFileManager extends Library {
    public String file_name = "library.txt"; // название файла с книгами


    public void createLibFile() {
        try {
            File file = new File(file_name);
            if (file.createNewFile()) {
                System.out.println("   ttt Файл библиотеки создан ttt");
            }
            else {
                BufferedReader reader = new BufferedReader(new FileReader(file_name));

                String line;

                while ((line = reader.readLine()) != null) {
                    Book book = new Book(); 
                    book.setInfo(line);
                    this.getBooksArray().add(book);
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println(" ttt Ошибка при создании файла ttt");
            e.printStackTrace();
        }
    }
    
    public boolean addBookToFile() {
        if (!this.addBook()) {
            return false;
        }
        
        try {
            FileWriter writer = new FileWriter(file_name, true);
            
            writer.write(this.getBooksArray().getLast().getInfo() + '\n');
            
            writer.close();

            return true;
        } catch (IOException e) {
            System.out.println(" ttt Ошибка при добавлении в файл ttt");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean printBooksList() { 
        if (this.getBooksArray().isEmpty()) {
            System.out.println("   !!! Библиотека пуста !!!");
            return false;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file_name));

            String line;

            System.out.println("   Информация о всех имеющихся книгах:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            return true;
        } catch (IOException e) {
            System.out.println("   ttt Ошибка при чтении файла ttt");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBookFromFile() {
        if (!deleteBook()) {
            return false;
        }

        try {
        FileWriter writer = new FileWriter(file_name);
        for (Book book : this.getBooksArray()) {
            writer.write(book.getInfo() + '\n');;
        }
        writer.close();
            
        return true;
        } catch (IOException e) {
            System.out.println("   ttt Ошибка при удалении книги ttt");
            e.printStackTrace();
            return false;
        }
    }
}
