public class Main {
    public static void main(String[] args) {
        Sensor h1 = new Sensor();
        TemperatureMeasure tc1 = new TemperatureMeasure(h1);
        for (int i = 0; i < 5; i++) {
            tc1.setValue();
        }
        ShowTemperature.show(tc1);
        System.out.println();

        Sensor h2 = new Sensor();
        TemperatureMeasure tc2 = new TemperatureMeasure(h2);
        for (int i = 0; i < 5; i++) {
            tc2.setValue();
        }
        ShowTemperature.show(tc2);
        System.out.println();

        System.out.println("Total: " + TemperatureMeasure.getTotal());
    }
}
