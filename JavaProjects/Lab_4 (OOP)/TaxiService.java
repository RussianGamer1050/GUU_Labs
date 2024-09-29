class TaxiService {

    private int number_of_cars = 16; // 16 машин из которых 8 бизнес, 8 эконом
    private Car[] cars_array; // весь таксопарк
    
    public int getNumberOfCars() {
        return number_of_cars;
    }

    public void setNumberOfCars(int number) {
        this.number_of_cars = number;
    }

    public Car[] getCarsArray() {
        return cars_array;
    }

    public void setCarsArray(Car[] array) {
        this.cars_array = array;
    }

    public void createTaxi() {
        Car[] cars_array = new Car[number_of_cars];
        for (int i = 0; i < number_of_cars; i++) {
            cars_array[i++] = new EconomCar();
            cars_array[i] = new BusinessCar();
        }
        this.setCarsArray(cars_array);
    }
}
