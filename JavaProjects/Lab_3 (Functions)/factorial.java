public class factorial {
    public static void main(String[] args) {
        System.out.println("Факториал 3: " + factorial(3));
        System.out.println("Факториал 4: " + factorial(4));
        System.out.println("Факториал 5: " + factorial(5));
    }
    
    // Рекурсивный метод
    public static int factorial(int n) {
        int result;

        if (n == 1)
            return 1;
        result = factorial(n - 1) * n;
        return result;
    }
}
