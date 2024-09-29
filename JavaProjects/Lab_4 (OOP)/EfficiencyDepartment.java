class EfficiencyDepartment extends FinancialDepartment {
    
    private int min_payroll;
    private int min_index;

    public int getMinPayroll() {
        return min_payroll;
    }

    public void setMinPayroll(int payroll) {
        this.min_payroll = payroll;
    }

    public int getMinIndex() {
        return min_index;
    }

    public void setMinIndex(int index) {
        this.min_index = index;
    }


    public void findMinPayroll() {
        min_index = 0;
        min_payroll = this.getDailyIncome()[0];
        
        for (int i = 1; i < this.getNumberOfCars(); i++) {
            if (this.getDailyIncome()[i] < min_payroll) {
                min_index = i; min_payroll = this.getDailyIncome()[i];
            }  
        }

        System.out.println("!!! " + (min_index + 1) + "-й водитель заработал меньше всего !!!\n");  
    }

    public void fireUnefficientDriver() {
        setCarsArray(Arrays.remove(this.getCarsArray(), min_index));
        this.setNumberOfCars(this.getNumberOfCars() - 1);
    }
}
