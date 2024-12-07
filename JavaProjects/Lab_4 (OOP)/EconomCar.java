import java.util.Random;

class EconomCar extends Car {

    private int min = 150;
    private int max = 350;

    EconomCar() {
        generateCar();
    }

    private void generateCar() {
        Random rand = new Random();
        int randomInRange = rand.nextInt(max - min + 1) + min;
        setPrice(randomInRange);
        setName("EconomCar" + randomInRange);
    }
    
    @Override
    public int calculate(int hours) {
        return getPrice() * hours;
    }
}
