class Arrays  {
    
    public static Car[] remove(Car[] array, int index) {
        Car[] new_array = new Car[array.length - 1];
        int j = 0; // индексы нового массива

        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                new_array[j++] = array[i];
            }
        }

        return new_array;
    }
}
