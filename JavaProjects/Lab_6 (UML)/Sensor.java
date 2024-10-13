class Sensor {
    private int value;

    
    public Sensor() {
        this.value = 0;
    }


    public void setValue(int value) {
        this.value += value;
    }

    public int getValue() {
        return value;
    }
}
