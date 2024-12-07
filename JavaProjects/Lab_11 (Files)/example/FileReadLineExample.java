import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadLineExample {
    public static void main(String[] args) {
        String filePath =  "example.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println("Содержимое файла построчно:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла.");
            e.printStackTrace();
        }
    }
}
