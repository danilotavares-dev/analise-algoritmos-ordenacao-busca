package busca;

import java.util.Random;
import java.util.Scanner;

public class BuscaSequencial {
    public static void main(String[] args) {
        System.out.print("Running...\n\n");

        Scanner input = new Scanner(System.in);
        int valor, linhas, colunas;
        int[][] matriz;
        int[] resultado;

        System.out.print("Quantidade de linhas: ");
        linhas = input.nextInt();

        System.out.print("Quantidade de colunas: ");
        colunas = input.nextInt();

        System.out.print("Digite um valor para a busca: ");
        valor = input.nextInt();

        matriz = gerarMatrizAleatoria(linhas, colunas);

        System.out.println("\n--- Matriz gerada --- \n");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%4d", matriz[i][j]);
            }
            System.out.println();
        }

        matriz[0][0] = 2000; // - Testar valor conhecido no início da matriz.
        matriz[linhas - 1][colunas - 1] = 1200; // - Testar valor conhecido no final da matriz.

        resultado = buscaValor(valor, matriz, linhas, colunas);
        System.out.println("\n--- Resultado da busca --- \n");

        if (resultado[0] == 1) {
            System.out.println("Valor encontrado!!");
            System.out.println("Linha: " + resultado[1]);
            System.out.println("Coluna: " + resultado[2]);
            System.out.println("Quantidade de comparações: " + resultado[3]);
        } else {
            System.out.println("Valor não encontrado");
            System.out.println("Quantidade de comparações: " + resultado[3]);
        }
    }

    public static int[][] gerarMatrizAleatoria(int qtdLinhas, int qtdColunas) {
        Random random = new Random(51);
        int[][] matriz = new int[qtdLinhas][qtdColunas];

        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                matriz[i][j] = random.nextInt(1000);
            }
        }
        return matriz;
    }

    public static int[] buscaValor(int valor, int[][] matriz, int linhas, int colunas) {
        int comparacoes = 0;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                comparacoes++;
                if (matriz[i][j] == valor) {
                    return new int[] {1, i, j, comparacoes};
                }
            }
        }
        return new int[] {0, -1, -1, comparacoes};
    }
}
