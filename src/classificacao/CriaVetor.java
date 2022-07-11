package classificacao;
public class CriaVetor {
    /*
    * Cria vetor com valores aleatórios a partir do tamanho informado.
    */
    public static int[] criaVetorAleatorio(int tamanho) {
        int vetor[] = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);
        }

        return vetor;
    }

    /*
     * Cria vetor do tamanho informado com valores crescente a partir de 0
     */
    public static int[] criaVetorCrescente(int tamanho) {
        int vetor[] = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i;
        }

        return vetor;
    }

    /*
     * Cria vetor do tamanho informado com valores decrescenetes
     */
    public static int[] criaVetorDecrescente(int tamanho) {
        int vetor[] = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = tamanho - i;
        }

        return vetor;
    }
}
