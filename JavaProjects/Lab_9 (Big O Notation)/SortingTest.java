import java.util.Arrays;
import java.util.Random;

public class SortingTest {
    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000); // случайные числа от 0 до 9999
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray(10000);

        // Тестируем сортировку пузырьком
        int[] array_for_bubble = Arrays.copyOf(array, array.length);
        long startTime = System.nanoTime();
        SortingAlgorithms.bubbleSort(array_for_bubble);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort time: " + (endTime - startTime) + " ns");
        
        // Тестируем сортировку выбором
        int[] array_for_selection = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        SortingAlgorithms.selectionSort(array_for_selection);
        endTime = System.nanoTime();
        System.out.println("Selection Sort time: " + (endTime - startTime) + " ns");
        
        // Тестируем сортировку выбором
        int[] array_for_insertion = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        SortingAlgorithms.insertionSort(array_for_insertion);
        endTime = System.nanoTime();
        System.out.println("Insertion Sort time: " + (endTime - startTime) + " ns");
        
        // Тестируем сортировку выбором
        int[] array_for_quick = Arrays.copyOf(array, array.length);
        startTime = System.nanoTime();
        SortingAlgorithms.quickSort(array_for_quick, 0, array_for_quick.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort time: " + (endTime - startTime) + " ns");
        
    }
}
