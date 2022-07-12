package testeCases;

import classificacao.CriaVetor;

public class BubbleSortTestCase {
    static long count = 0;

    public static int[] bubblesort1(int v[]) {
        count = 0;
        
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                count++;
                if (v[i] > v[j]) {
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
        
        return v;
    }
    
    public static void melhorCaso() {
        int vetor[];
        
        System.out.println("BubbleSort1 - Array Crescente");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            vetor = CriaVetor.criaVetorCrescente(tamanhoVetor);
            bubblesort1(vetor);
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + count);
        }
    }

    public static void piorCaso() {
        int vetor[];
        System.out.println("BubbleSort1 - Array Decrescente");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            vetor = CriaVetor.criaVetorDecrescente(tamanhoVetor);
            bubblesort1(vetor);
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + count);
        }
    }

    public static void casoMedio() {
        long media;
        long somaOperacoes;
        int vetor[];

        System.out.println("BubbleSort1 - Array Aleatório");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            media = 0;
            somaOperacoes = 0;

            for (int execucoes = 1; execucoes <= 10; execucoes++) {
                vetor = CriaVetor.criaVetorAleatorio(tamanhoVetor);
                
                bubblesort1(vetor);

                somaOperacoes += count;
            }

            media = somaOperacoes / 10;
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + media);
        }
    }
    
}
