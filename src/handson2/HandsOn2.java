package handson2;

import java.util.Random;
import java.util.Scanner;

public class HandsOn2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int linhas = 5, colunas = 24, indiceMaior = 0, horarioMaiorTemp = 0;
        int qtdAcimaLimite = 0;
        float[][] sensores = new float[linhas][colunas];
        float somaSensores, mediaSensores, somaTotal = 0, mediaTotal;
        float maior = 0, limiteTemp;

        System.out.print("Valor limite de temperatura: ");
        limiteTemp = input.nextFloat();

        sensores = gerarMatrizAleatoria(linhas, colunas);

        System.out.println("\n--- Matriz Gerada --- \n");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.printf("%8.2f", sensores[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n--- Média por Sensor --- \n");
        for (int i = 0; i < linhas; i++) {
            somaSensores = 0;
            for (int j = 0; j < colunas; j++) {
                if (sensores[i][j] > limiteTemp)
                    qtdAcimaLimite++;
                if (sensores[i][j] > maior) {
                    maior = sensores[i][j];
                    indiceMaior = i + 1;
                    horarioMaiorTemp = j;
                }
                somaSensores += sensores[i][j];
                somaTotal += sensores[i][j];
            }
            mediaSensores = somaSensores / colunas;
            System.out.println("Média do sensor " + (i + 1) + ": " + mediaSensores);
        }
        mediaTotal = somaTotal / (linhas * colunas);

        System.out.println("\n--- Maior Temperatura Geral --- \n");
        System.out.println("Maior temperatura registrada: " + maior);
        System.out.println("Sensor com a maior temperatura registrada: " + indiceMaior);
        System.out.println("Horário da maior temperatura registrada: " + horarioMaiorTemp);

        System.out.println("\n--- Média de Temperatura Geral --- \n");
        System.out.println("Média Geral: " + mediaTotal);

        System.out.println("\n--- Leituras acima do limite --- \n");
        System.out.println("Limite informado: " + limiteTemp + "°C");
        System.out.println("Quantidade de leituras acima do limite: " + qtdAcimaLimite);
    }

    public static float[][] gerarMatrizAleatoria(int qtdLinhas, int qtdColunas) {
        Random random = new Random(51);
        float[][] matriz = new float[qtdLinhas][qtdColunas];

        for (int i = 0; i < qtdLinhas; i++) {
            for (int j = 0; j < qtdColunas; j++) {
                matriz[i][j] = Math.round(random.nextFloat(57) * 100) / 100.0f;
            }
        }
        return matriz;
    }
}
