package testeCases;

import classificacao.CriaVetor;

public class InsertionSortTestCase {
    static int count = 0;
    
    public static int[] insertionsort(int v[]) {
        count = 0;

        int pivo, j;
        for (int i = 1; i < v.length; i++) {
            count++;
            pivo = v[i];
            j = i - 1;
            
            while (j >= 0 && pivo < v[j]) {
                count++;
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = pivo;
        }
        return v;
    }

    public static void piorCaso() {
        int vetor[];

        System.out.println("InsertionSort - Array Decrescente");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            vetor = CriaVetor.criaVetorDecrescente(tamanhoVetor);
            insertionsort(vetor);
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + count);
        }
    }

    public static void casoMedio() {
        long media;
        long somaOperacoes;
        int vetor[];

        System.out.println("InsertionSort - Array Aleatório");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            media = 0;
            somaOperacoes = 0;

            for (int execucoes = 1; execucoes <= 10; execucoes++) {
                vetor = CriaVetor.criaVetorAleatorio(tamanhoVetor);
                insertionsort(vetor);
                somaOperacoes += count;
            }

            media = somaOperacoes / 10;
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + media);
        }
    }
    
}
