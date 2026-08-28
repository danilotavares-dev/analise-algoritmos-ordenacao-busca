package ordenacao;

public class SortingUtils {

    static int comparacoes = 0;
    static int trocas = 0;

    public static void resetCounters() {
        comparacoes = 0;
        trocas = 0;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                comparacoes++;
                if (array[j] > array[j + 1]) {
                    trocas++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        int inicio = low, fim = high;
        int pivot = array[(inicio + fim) / 2];

        while (inicio <= fim) {
            while (array[inicio] < pivot) {
                comparacoes++;
                inicio++;
            }
            comparacoes++;

            while (array[fim] > pivot) {
                comparacoes++;
                fim--;
            }
            comparacoes++;

            if (inicio <= fim) {
                trocas++;
                int temp = array[inicio];
                array[inicio] = array[fim];
                array[fim] = temp;
                inicio++;
                fim--;
            }
        }

        if (fim - low > 0) quickSort(array, low, fim);
        if (high - inicio > 0) quickSort(array, inicio, high);
    }
}