package testeCases;

import classificacao.CriaVetor;

public class MergeSortTestCase {
    static int count = 0;
    
    public static void mergesort(int v[]) {
        mergesort(v, 0, v.length - 1);
    }

    public static void mergesort(int v[], int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        
        if (inicio < fim) {
            mergesort(v, inicio, meio);
            mergesort(v, meio + 1, fim);
            
            merge(v, inicio, meio, fim);
        }
    }

    public static void merge(int v[], int inicio, int meio, int fim) {
        int aux[] = new int[(fim + 1) - inicio];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            count++;
            aux[k++] = v[i] <= v[j] ? v[i++] : v[j++];
        }

        while (i <= meio) {
            count++;
            aux[k++] = v[i++];
        }

        while (j <= fim) {
            count++;
            aux[k++] = v[j++];
        }
        
        for (i = inicio, k = 0; i <= fim; i++, k++) {
            count++;
            v[i] = aux[k];
        }
    }

    public static void piorCaso() {
        int vetor[];

        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            vetor = CriaVetor.criaVetorDecrescente(tamanhoVetor);
            mergesort(vetor);
            System.out.println("MergeSort_PiorCaso_Tamanho_" + tamanhoVetor + "_MédiaDeOperações_" + count);
        }
    }

    public static void casoMedio() {
        long media;
        long somaOperacoes;
        int vetor[];

        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            media = 0;
            somaOperacoes = 0;

            for (int execucoes = 1; execucoes <= 10; execucoes++) {
                vetor = CriaVetor.criaVetorAleatorio(tamanhoVetor);
                mergesort(vetor);
                somaOperacoes += count;
            }

            media = somaOperacoes / 10;
            System.out.println("MergeSort_CasoMedio_Tamanho_" + tamanhoVetor + "_MédiaDeOperações_" + media);
        }
    }

}
