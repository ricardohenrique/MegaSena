/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;

import java.util.Random;

/**
 *
 * @author internet teste
 */
public class MegaSena {
    
    public static void main(String[] args) {
        int quantidadeDeNumeroSorteado = 6, linha = 0, coluna = 0;
        int matriz[][] = new int[3000][quantidadeDeNumeroSorteado];
        int countNumeroX[][] = new int[61][2];
        int vetorOrdenado[] = new int[6];
        int matrizCountDupla[][] = new int[61][61];
        Sort sort = new Sort();
        
        
        Random random = new Random();
        String resultado = "", resultadoFinal = "", resultadoOrdenado = "", resultadoQuantidadePorNumero = "", resultadoDupla = "";
        
        for (int i = 0; i < 61; i++) {
            countNumeroX[i][0] = i;
            countNumeroX[i][1] = 0;
        }
        
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                matrizCountDupla[i][j] = 0;
            }
        }
        
        for (linha = 0; linha < 3000; linha++) {
            final int[] sorteio = random.ints(1, 61).distinct().limit(quantidadeDeNumeroSorteado).toArray();
            for (coluna = 0; coluna < quantidadeDeNumeroSorteado; coluna++) {
                matriz[linha][coluna] = sorteio[coluna];
                for (int i = 0; i < 61; i++) {
                    if(countNumeroX[i][0] == matriz[linha][coluna]) {
                        countNumeroX[i][1] = countNumeroX[i][1] + 1;
                    }
                }
            }
        }

        for (linha = 0; linha < 3000; linha++) {
            for(coluna = 0; coluna < quantidadeDeNumeroSorteado; coluna++){
                resultado = resultado + String.format("%1$02d ", matriz[linha][coluna]);
                vetorOrdenado[coluna] = matriz[linha][coluna];
            }
            sort.bubbleSort(vetorOrdenado, quantidadeDeNumeroSorteado);
            for (coluna = 0; coluna < quantidadeDeNumeroSorteado; coluna++) {
                resultadoOrdenado = resultadoOrdenado + String.format("%1$02d ", vetorOrdenado[coluna]);
            }
            for (int i = 0; i < 61; i++) {
                for (int j = 0; j < 61; j++) {
                    //compara primeiro número com os demais
                    if (vetorOrdenado[0] == i && vetorOrdenado[1] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[0] == i && vetorOrdenado[2] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[0] == i && vetorOrdenado[3] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[0] == i && vetorOrdenado[4] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[0] == i && vetorOrdenado[5] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    
                    //compara segundo número com os demais
                    if (vetorOrdenado[1] == i && vetorOrdenado[2] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[1] == i && vetorOrdenado[3] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[1] == i && vetorOrdenado[4] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[1] == i && vetorOrdenado[5] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    
                    //compara terceiro número com os demais
                    if (vetorOrdenado[2] == i && vetorOrdenado[3] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[2] == i && vetorOrdenado[4] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[2] == i && vetorOrdenado[5] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    
                    //compara quarto número com os demais
                    if (vetorOrdenado[3] == i && vetorOrdenado[4] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    if (vetorOrdenado[3] == i && vetorOrdenado[5] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                    
                    //compara quinto número com os demais
                    if (vetorOrdenado[4] == i && vetorOrdenado[5] == j) matrizCountDupla[i][j] = matrizCountDupla[i][j] + 1;
                }
            }
            resultadoFinal = String.format("Sorteio[%1$04d]: " + resultado + "[ " + resultadoOrdenado + "]", (linha+1));;
            System.out.println(resultadoFinal);
            resultado = "";
            resultadoOrdenado = "";
        }
        
        for (int i = 1; i < 61; i++) {
            resultadoQuantidadePorNumero = resultadoQuantidadePorNumero + String.format("Numero %1$02d = %2$04d vezes\n", i, countNumeroX[i][1]);
        }
        System.out.println(resultadoQuantidadePorNumero);

        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                resultadoDupla += String.format("%1$02d " ,matrizCountDupla[i][j]);
            }
            resultadoDupla += "\n";
        }
        System.out.println(resultadoDupla);
//        ------------------------------------------------------------        
        int maiores[] = new int[15];
        for (int i = 0; i < 15; i++) {
            maiores[i] = 0;
        }
        String Maior1 = "", Maior2 = "";
        int numero1 = 0, numero2 = 0;
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                if (matrizCountDupla[i][j] > numero1){
                    maiores[14] = matrizCountDupla[i][j];
                    numero1 = matrizCountDupla[i][j];
                    Maior1 = "\n1º maior dupla " + i + " e " + j + " -> " + maiores[14];
                }
            }
        }
        
        System.out.println(Maior1);
        System.out.println(Maior2);
//        -----------------------------------------------------------------

        
    }
    
}
