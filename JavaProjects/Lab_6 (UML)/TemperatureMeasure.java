import java.util.Scanner;

class TemperatureMeasure implements ITemperatureMeasure {
    private Sensor h;
    private MeasureCount measure;
    
    public TemperatureMeasure(Sensor h) {
        this.h = h;
        this.measure = new MeasureCount();
    }

    public int getNumber() {
        return measure.getNumber();
    }

    public double getValue() {
        return (double) h.getValue() / measure.getNumber();
    }

    public void setValue() {
        Scanner scanner = new Scanner(System.in);
        measure.increment();
        System.out.print("t[" + measure.getNumber() + "]= ");
        int value = scanner.nextInt();
        h.setValue(value);
        // scanner.close(); Почему то не работает, если закрывать поток
    }

    public static int getTotal() {
        return MeasureCount.getTotal();
    }
}
