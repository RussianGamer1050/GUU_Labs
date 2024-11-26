import java.io.FileWriter;
import java.io.IOException;

public class FileAppendExample {
    public static void main(String[] args) {
        String filePath = "example.txt";

        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write("Третья строка.\n");
            writer.write("Четвёртая строка.\n");
            writer.close();
            System.out.println("Успешно добавлено в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при добавлении в файл.");
            e.printStackTrace();
        }
    }
}
