import java.util.Random;

class FinancialDepartment extends TaxiService {
    
    private int[] daily_income = new int[this.getNumberOfCars()]; // доход за день по каждому авто
    private int income = 0; // доход за весь период

    public int[] getDailyIncome() {
        return daily_income;
    }

    public void setDailyIncome(int[] income) {
        this.daily_income = income;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int sum) {
        this.income = sum;
    }


    public void countDailyIncome() {
        for (int i = 0; i < this.getNumberOfCars(); i++) {
            Random rand = new Random();
            int rand_hours = rand.nextInt(9); // {0, 1, 2, ... 8}

            daily_income[i] = this.getCarsArray()[i].getPrice() * rand_hours;
            income += daily_income[i];
            System.out.println((i + 1) + ". " + this.getCarsArray()[i].getName() + " - " + daily_income[i] + " у. е.");
        }
        System.out.println("Итоговая выручка: " + income + "\n");
        this.setDailyIncome(daily_income);
        this.setIncome(income);
    }
}
