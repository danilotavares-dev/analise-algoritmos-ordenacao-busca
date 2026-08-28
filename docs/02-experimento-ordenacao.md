# Parte 2 — Experimento de Ordenação

[⬅ Voltar ao README principal](../README.md)

Programa desenvolvido para comparar experimentalmente Bubble Sort e Quick Sort, utilizando exatamente os mesmos dados de entrada em ambos os algoritmos (uma cópia do array original para cada algoritmo), contabilizando comparações e trocas.

## Código

### `ordenacao.SortingUtils.java`

```java
public class ordenacao.SortingUtils {
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
```

### `ordenacao.Main.java`

```java
import ordenacao.SortingUtils;

import java.util.Arrays;
import java.util.Random;

public class ordenacao.Main {
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

        int[] paraBubble = Arrays.copyOf(original, original.length);
        SortingUtils.resetCounters();
        SortingUtils.bubbleSort(paraBubble);
        int comparacoesBubble = SortingUtils.comparacoes;
        int trocasBubble = SortingUtils.trocas;

        int[] paraQuick = Arrays.copyOf(original, original.length);
        SortingUtils.resetCounters();
        SortingUtils.quickSort(paraQuick, 0, paraQuick.length - 1);
        int comparacoesQuick = SortingUtils.comparacoes;
        int trocasQuick = SortingUtils.trocas;

        System.out.println("Tamanho: " + size);
        System.out.println("Bubble Sort - Comparações: " + comparacoesBubble + " | Trocas: " + trocasBubble);
        System.out.println("Quick Sort  - Comparações: " + comparacoesQuick + " | Trocas: " + trocasQuick);
        System.out.println();
    }
}
```

> Ambos os algoritmos usam a mesma semente aleatória (`Random(51)`) e operam sobre cópias independentes (`Arrays.copyOf`) do mesmo array original, garantindo que a comparação seja justa.

## Resultados obtidos

| Tamanho do Array | Bubble Sort – Comparações | Bubble Sort – Trocas | Quick Sort – Comparações | Quick Sort – Movimentações |
|---|---|---|---|---|
| 10 | 45 | 19 | 36 | 10 |
| 20 | 190 | 95 | 120 | 27 |
| 1.000 | 499.500 | 253.113 | 13.466 | 2.690 |

## Respostas

**a) Qual algoritmo realizou menos operações para 10 elementos?**

O Quick Sort. Somando comparações e trocas, o Quick Sort fez 46 operações (36 comparações + 10 trocas), contra 64 do Bubble Sort (45 comparações + 19 trocas). Mesmo nesse tamanho pequeno, o Quick Sort já foi mais eficiente.

**b) O comportamento permaneceu igual para 20 elementos?**

Sim, a tendência se manteve e ficou ainda mais evidente. Com 20 elementos, o Bubble Sort saltou para 285 operações (190 comparações + 95 trocas), enquanto o Quick Sort ficou em 147 (120 comparações + 27 trocas). A diferença proporcional entre os dois já começa a crescer.

**c) O que aconteceu quando o tamanho aumentou para 1.000 elementos?**

A diferença se tornou drástica. O Bubble Sort chegou a 499.500 comparações e 253.113 trocas (752.613 operações no total), enquanto o Quick Sort fez apenas 13.466 comparações e 2.690 trocas (16.156 no total). Isso significa que o Bubble Sort realizou quase 47 vezes mais operações que o Quick Sort para o mesmo conjunto de dados.

**d) Qual algoritmo apresentou maior crescimento da quantidade de operações?**

O Bubble Sort, disparadamente. Enquanto o Quick Sort cresceu de forma suave e controlada (46 → 147 → 16.156), o Bubble Sort explodiu (64 → 285 → 752.613). Esse crescimento reflete diretamente a diferença entre complexidade O(n²) e O(n log n).

**e) Os resultados experimentais são coerentes com as complexidades teóricas estudadas?**

Sim, totalmente. A teoria prevê que o Bubble Sort cresce quadraticamente (O(n²)), ou seja, se o tamanho da entrada aumenta 100 vezes (de 10 para 1.000), o número de operações deveria aumentar aproximadamente 100² = 10.000 vezes. Na prática, as comparações do Bubble Sort foram de 45 para 499.500, um crescimento de aproximadamente 11.100 vezes, o que é coerente com o esperado. Já o Quick Sort, com complexidade O(n log n), cresce de forma muito mais lenta, e os números confirmam isso: as comparações foram de 36 para 13.466, um crescimento bem mais moderado que o quadrático do Bubble Sort.

**f) Em qual situação você escolheria Bubble Sort?**

Em situações onde o conjunto de dados é muito pequeno, quando o array já está quase ordenado (com a otimização de parada antecipada), ou em contextos puramente didáticos, onde a simplicidade do algoritmo importa mais que a performance. Não é uma escolha adequada para dados de produção ou conjuntos grandes.

**g) Em qual situação você escolheria Quick Sort?**

Em praticamente qualquer cenário de uso real, especialmente com conjuntos de dados grandes, onde performance é importante. É a escolha adequada quando não há restrição de estabilidade na ordenação, e quando se pode usar uma boa estratégia de pivô para evitar o pior caso O(n²), como a utilizada neste experimento (pivô no meio do intervalo), que já ajuda a evitar esse problema em arrays já ordenados.

---

[➡ Próxima parte: Parte 3 — Busca em Matrizes](03-busca-matrizes.md)