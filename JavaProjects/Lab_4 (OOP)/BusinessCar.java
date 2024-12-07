import java.util.Random;

class BusinessCar extends Car {

    private int min = 450;
    private int max = 600;

    BusinessCar() {
        generateCar();
    }

    private void generateCar() {
        Random rand = new Random();
        int randomInRange = rand.nextInt(max - min + 1) + min;
        setPrice(randomInRange);
        setName("BusinessCar" + randomInRange);
    }

    @Override
    public int calculate(int hours) {
        return getPrice() * hours;
    }
}
