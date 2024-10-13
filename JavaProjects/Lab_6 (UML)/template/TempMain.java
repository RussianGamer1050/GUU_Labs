public class TempMain {
    private static void printRes(MyResult r) {
        if (r.hasResult()) {
            System.out.println("Результат исполнения: " + r.getResult());
        }
        else {
            System.out.println("Результат отсутствует");
        }
    }

    public static void main(String[] args) {
        MyCalculator c1 = new MyCalculator('/');
        MyResult r;
        r = c1.calculate(4, 2);
        printRes(r);
        r = c1.calculate(40, 13);
        printRes(r);
        r = c1.calculate(1, 0);
        printRes(r);

        c1 = new MyCalculator('^');
        r = c1.calculate(2, 25);
        printRes(r);
    }
}
