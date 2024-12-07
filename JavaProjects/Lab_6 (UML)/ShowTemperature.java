class ShowTemperature {
    public static void show(TemperatureMeasure t) {
        System.out.print(t.getNumber() + ": ");
        System.out.println(t.getValue() + " C");
    }
}
