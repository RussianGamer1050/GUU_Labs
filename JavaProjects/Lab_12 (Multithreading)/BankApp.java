import java.util.Scanner;

public class BankApp {

    public static int optionFoolChecker(Scanner in) {
        int option;
        do {
                
            System.out.print("- Введите необходимый вариант: ");
            if (in.hasNextInt()) {
                
                option = in.nextInt(); in.nextLine();
                
                if (0 < option && option > 3) {
                    System.out.println("! Неизвестный вариант !\n");
                    continue;
                } else {
                    break;
                }
                
            } else {
                System.out.println("! Введенный вариант должен быть числом !\n"); in.nextLine();
            }

        } while(true);

        return option;
    }

    public static int IntRangeFoolChecker(Scanner in, int a) {
        int number;

        do {

            while (!in.hasNextInt()) {
                System.out.println("! Должно быть введено целое число !\n"); in.nextLine();
            }

            number = in.nextInt(); in.nextLine();

            if (number <= a) {
                System.out.println("! Должно быть введено положительное число !\n");
            } else {
                break;
            }

        } while(true);
        
        return number;
    }

    public static void main(String[] args) {
        // Создание "аккаунта"
        BankAccount bank_account = new BankAccount();

        // Создание и запуск потоков
        DepositThread DepositThread = new DepositThread(bank_account);
        WithdrawThread WithdrawThread = new WithdrawThread(bank_account);

        DepositThread.start();
        WithdrawThread.start();

        // User-интерфейс
        Scanner in = new Scanner(System.in);

        System.out.println("    Добро пожаловать!   ");
        int option;

        do {
            // Меню выбора
            System.out.println("Текущий баланс: " + bank_account.getBalance() + " руб.");
            System.out.println("| 1) Пополнение;");
            System.out.println("| 2) Списание;");
            System.out.println("| 3) Выход;\n");
            
            // Проверка на дурака
            option = optionFoolChecker(in);
            int sum = 0;

            switch (option) {
                case 1:
                    // Пополнение баланса
                    System.out.print("- Введите сумму пополнения: ");
                    sum = IntRangeFoolChecker(in, 0);
                    
                    DepositThread.setSum(sum);
                    
                    // Ожидание выполнения непрерывного потока
                    while (!DepositThread.isTaskCoplete()) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }
                    }

                    break;
                case 2:
                    // Снятие со счёта
                    System.out.print("- Введите сумму снятия: ");
                    sum = IntRangeFoolChecker(in, 0);

                    WithdrawThread.setSum(sum);
                    
                    // Ожидание выполнения непрерывного потока
                    while (!WithdrawThread.isTaskCoplete()) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }
                    }

                    break;
                case 3:
                    // Выход из программы
                    break;
            }

        } while(option != 3);

        in.close();
        
        // Закрытие потоков
        DepositThread.close();
        WithdrawThread.close();
        
        try {
            DepositThread.join();
            WithdrawThread.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}