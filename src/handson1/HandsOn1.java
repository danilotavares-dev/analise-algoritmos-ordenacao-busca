package handson1;

import java.util.Scanner;

public class HandsOn1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float[] temperatura = new float[10];
        int operacoes = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite a temperatura do índice " + (i + 1) + ": ");
            float valor = input.nextFloat();
            temperatura[i] = valor;
            operacoes++;
        }

        System.out.println("\n--- TEMPERATURAS ---\n");
        for (int i = 0; i < 10; i++) {
            System.out.println("Índice " + i + ": " + temperatura[i] + "ºC");
            operacoes++;
        }

        float soma = 0;
        float maior = temperatura[0];
        float menor = temperatura[0];
        int indiceMaior = 0;
        int indiceMenor = 0;

        for (int i = 0; i < 10; i++) {
            soma += temperatura[i];
            operacoes++;
            if (temperatura[i] > maior) {
                maior = temperatura[i];
                indiceMaior = i;
            }
            if (temperatura[i] < menor) {
                menor = temperatura[i];
                indiceMenor = i;
            }
        }

        float media = soma / 10.0f;
        int acimaMedia = 0;

        for (int i = 0; i < 10; i++) {
            operacoes++;
            if (temperatura[i] > media) {
                acimaMedia += 1;
            }
        }

        System.out.println("\n--- RESULTADOS ---\n");

        System.out.println("Média: " + media + "ºC ");
        System.out.println("Maior temperatura: " + maior + "ºC");
        System.out.println("Índice do maior valor: " + indiceMaior);
        System.out.println("Menor temperatura: " + menor + "ºC");
        System.out.println("Índice do Menor valor: " + indiceMenor);
        System.out.println("Quantidade de valores acima da média: " + acimaMedia);
        System.out.println("Quantidade de operações de percurso: " + operacoes);

    }
}