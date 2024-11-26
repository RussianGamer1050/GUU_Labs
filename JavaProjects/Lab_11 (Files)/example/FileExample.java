import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("Файл Создан " + file.getName());
            }
            else {
                System.out.println("Файл уже существует.");
            }

            FileWriter writer = new FileWriter(filePath);
            writer.write("Первая строка.\n");
            writer.write("Вторая строка.\n");
            writer.close();
            System.out.println("Учпешно записано в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом.");
            e.printStackTrace();
        }
    }
}