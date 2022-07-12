package testeCases;

import classificacao.CriaVetor;

public class HeapSortTestCase {
    static int count = 0;

    public static void heapsort(int v[]) {
        count = 0;

        for (int i = v.length / 2 - 1; i >= 0; i--) {
            heapify(v, v.length, i);
        }
    
        for (int i = v.length - 1; i > 0; i--) {
            swap(v, 0, i); 
            
            heapify(v, i, 0);
        }
    }

    public static void heapify(int v[], int n, int i) {
        int raiz = i;
        
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
    
        if (esquerda < n && v[esquerda] > v[raiz]) {    
            raiz = esquerda;
        }
    
        if (direita < n && v[direita] > v[raiz]) {
            raiz = direita;
        }
    
        count++;
        if (raiz != i) {
            swap(v, i, raiz);
            heapify(v, n, raiz);
        }
    }

    public static void swap(int v[], int i, int j) {
        int aux = v[j];
            v[j] = v[i];
            v[i] = aux;
    }

    public static void melhorCaso() {
        int vetor[];
        
        System.out.println("HeapSort - Array Crescente");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            vetor = CriaVetor.criaVetorCrescente(tamanhoVetor);
            heapsort(vetor);
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + count);
        }
    }

    public static void piorCaso() {
        int vetor[];

        System.out.println("HeapSort - Array Decrescente");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            vetor = CriaVetor.criaVetorDecrescente(tamanhoVetor);
            heapsort(vetor);
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + count);
        }
    }

    public static void casoMedio() {
        long media;
        long somaOperacoes;
        int vetor[];

        System.out.println("HeapSort - Array Aleatório");
        for (int tamanhoVetor = 1; tamanhoVetor <= 1000; tamanhoVetor++) {
            media = 0;
            somaOperacoes = 0;

            for (int execucoes = 1; execucoes <= 10; execucoes++) {
                vetor = CriaVetor.criaVetorAleatorio(tamanhoVetor);
                heapsort(vetor);
                somaOperacoes += count;
            }

            media = somaOperacoes / 10;
            System.out.println("Tamanho: " + tamanhoVetor + " | Média de Operações: " + media);
        }
    }

}
