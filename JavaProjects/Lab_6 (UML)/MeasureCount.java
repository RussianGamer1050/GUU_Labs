class MeasureCount {
    private int number;
    private static int total;


    public MeasureCount() {
        this.number = 0;
    }

    public void increment() {
        number++;
        total++;
    }


    public int getNumber() {
        return number;
    }

    public static int getTotal() {
        return total;
    }
}
