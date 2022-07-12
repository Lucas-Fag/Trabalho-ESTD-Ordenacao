package testeCases;

import classificacao.CriaVetor;

public class QuickSortTestCase {
    static int count = 0;

    public static void quicksort(int v[]) {
        count = 0;
        quicksort(v,  0, v.length - 1);
    }

    public static void quicksort(int v[], int inicio, int fim) {
        if (inicio < fim) {
            int meio = partition(v, inicio, fim);
            
            quicksort(v, inicio, meio - 1);
            quicksort(v, meio + 1, fim);
        }
    }

    public static void swap(int v[], int i, int j) {
        int aux = v[j];
            v[j] = v[i];
            v[i] = aux;
    }

    public static int partition(int v[], int inicio, int fim) {
       int pivo = v[fim];      
       int i = (inicio - 1);
   
       for (int j = inicio; j <= fim - 1; j++) {
            count++;
           if (v[j] < pivo) {
               i++;
               
               swap(v, i, j);
           }
       }

       swap(v, i + 1, fim);
       
       return i + 1;
   }

   public static void melhorCaso() {
    int vetor[];
    
    System.out.println("QuickSort - Array Crescente");
    for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
        vetor = CriaVetor.criaVetorCrescente(tamanhoVetor);
        quicksort(vetor);
        System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + count);
    }
}

    public static void piorCaso() {
        int vetor[];

        System.out.println("QuickSort - Array Decrescente:");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            vetor = CriaVetor.criaVetorDecrescente(tamanhoVetor);
            quicksort(vetor);
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + count);
        }
    }

    public static void casoMedio() {
        long media;
        long somaOperacoes;
        int vetor[];

        System.out.println("QuickSort - Array Aleatório:");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            media = 0;
            somaOperacoes = 0;

            for (int execucoes = 1; execucoes <= 10; execucoes++) {
                vetor = CriaVetor.criaVetorAleatorio(tamanhoVetor);
                quicksort(vetor);
                somaOperacoes += count;
            }

            media = somaOperacoes / 10;
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + media);
        }
    }

}
