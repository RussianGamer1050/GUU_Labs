import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {
    
    public static void main(String[] args) {
        // Второй пример
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        
        List<Integer> doubled = evenNumbers.stream()
            .map(n -> n * 2)
            .collect((Collectors.toList()));
        
        doubled.forEach(System.out::println);

        // Первый пример
        Operation addition = (a, b) -> a + b;
        Operation subtraction = (a, b) -> a - b;
        Operation multiplication = (a, b) -> a * b;
        Operation division = (a, b) -> 
        {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        };
        
        System.out.println("Addition: " + addition.apply(5, 3));
        System.out.println("Subtraction: " + subtraction.apply(5, 3));
        System.out.println("Multiplication: " + multiplication.apply(5, 3));
        System.out.println("Division: " + division.apply(5, 3));
    }
}
