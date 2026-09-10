package ordenacao;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running...\n");

        rodarExperimento(10);
        rodarExperimento(20);
        rodarExperimento(1000);
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random(51);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    public static void rodarExperimento(int size) {
        int[] original = generateRandomArray(size);

        // Bubble Sort
        int[] paraBubble = Arrays.copyOf(original, original.length);
        SortingUtils.resetCounters();
        SortingUtils.bubbleSort(paraBubble);
        int comparacoesBubble = SortingUtils.comparacoes;
        int trocasBubble = SortingUtils.trocas;

        // Selection Sort
        int[] paraSelection = Arrays.copyOf(original, original.length);
        SortingUtils.resetCounters();
        SortingUtils.selectionSort(paraSelection);
        int comparacoesSelection = SortingUtils.comparacoes;
        int trocasSelection = SortingUtils.trocas;

        // Insertion Sort
        int[] paraInsertion = Arrays.copyOf(original, original.length);
        SortingUtils.resetCounters();
        SortingUtils.insertionSort(paraInsertion);
        int comparacoesInsertion = SortingUtils.comparacoes;
        int trocasInsertion = SortingUtils.trocas;


        // Quick Sort
        int[] paraQuick = Arrays.copyOf(original, original.length);
        SortingUtils.resetCounters();
        SortingUtils.quickSort(paraQuick, 0, paraQuick.length - 1);
        int comparacoesQuick = SortingUtils.comparacoes;
        int trocasQuick = SortingUtils.trocas;

        System.out.println("Tamanho: " + size);
        System.out.println("Bubble Sort - Comparações: " + comparacoesBubble + " | Trocas: " + trocasBubble);
        System.out.println("Selection Sort  - Comparações: " + comparacoesSelection + " | Trocas: " + trocasSelection);
        System.out.println("Insertion Sort  - Comparações: " + comparacoesInsertion + " | Trocas: " + trocasInsertion);
        System.out.println("Quick Sort  - Comparações: " + comparacoesQuick + " | Trocas: " + trocasQuick);
        System.out.println();
    }
}