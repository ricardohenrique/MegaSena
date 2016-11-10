/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ricardo Mota
 */
public class Jogos {
    public int linha;
    public int coluna;
    public int quantidadeDeNumeroSorteado;
    public int matriz[][] = new int[3000][6];
    public int countNumeroX[][] = new int[61][2];
    public Sort sort = new Sort();
    public Scanner scanner = new Scanner(System.in);
    
    public Jogos(){
        this.linha = 0;
        this.coluna = 0;
        this.quantidadeDeNumeroSorteado = 6;
                
        for (int i = 0; i < 61; i++) {
            this.countNumeroX[i][0] = i;
            this.countNumeroX[i][1] = 0;
        }
    }
    
    public void popularJogos(){
        Random random = new Random();
        for (this.linha = 0; this.linha < 3000; this.linha++) {
            final int[] sorteio = random.ints(1, 61).distinct().limit(this.quantidadeDeNumeroSorteado).toArray();
            for (this.coluna = 0; this.coluna < this.quantidadeDeNumeroSorteado; this.coluna++) {
                this.matriz[this.linha][this.coluna] = sorteio[this.coluna];
                for (int i = 0; i < 61; i++) {
                    if(this.countNumeroX[i][0] == this.matriz[this.linha][this.coluna]) {
                        this.countNumeroX[i][1] = this.countNumeroX[i][1] + 1;
                    }
                }
            }
        }
    }
    
    public void mostrarJogos(){
        String resultado = "", resultadoFinal, resultadoOrdenado = "";
        int vetorOrdenado[] = new int[6];
        
        for (this.linha = 0; this.linha < 3000; this.linha++) {
            for(this.coluna = 0; this.coluna < this.quantidadeDeNumeroSorteado; this.coluna++){
                resultado = resultado + String.format("%1$02d ", this.matriz[this.linha][this.coluna]);
                vetorOrdenado[this.coluna] = this.matriz[this.linha][this.coluna];
            }
            this.sort.bubbleSort(vetorOrdenado, this.quantidadeDeNumeroSorteado);
            for (this.coluna = 0; this.coluna < this.quantidadeDeNumeroSorteado; this.coluna++) {
                resultadoOrdenado = resultadoOrdenado + String.format("%1$02d ", vetorOrdenado[this.coluna]);
            }
            resultadoFinal = String.format("Sorteio[%1$04d]: " + resultado + "[ " + resultadoOrdenado + "]", (this.linha+1));;
            System.out.println(resultadoFinal);
            resultado = "";
            resultadoOrdenado = "";
        }
    }
    
    public void mostrarCountNumeros(){
        String resultadoQuantidadePorNumero = "";
        for (int i = 1; i < 61; i++) {
            resultadoQuantidadePorNumero = resultadoQuantidadePorNumero + String.format("Numero %1$02d = %2$04d vezes\n", i, this.countNumeroX[i][1]);
        }
        System.out.println(resultadoQuantidadePorNumero);	
    }
    
    public void duplasMaisSorteadas(){
        int vetorOrdenado[] = new int[6];
        String resultado = "";
        int matrizCountDupla[][] = new int[61][61];
        
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                matrizCountDupla[i][j] = 0;
            }
        }
        
        
        for (this.linha = 0; this.linha < 3000; this.linha++) {
            for(this.coluna = 0; this.coluna < this.quantidadeDeNumeroSorteado; this.coluna++){
                resultado = resultado + String.format("%1$02d ", this.matriz[this.linha][this.coluna]);
                vetorOrdenado[this.coluna] = this.matriz[this.linha][this.coluna];
            }
            this.sort.bubbleSort(vetorOrdenado, this.quantidadeDeNumeroSorteado);
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
        }
        
        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                if (matrizCountDupla[i][j] > 0){
                    System.out.println("Dupla: " + i + " e " + j + " -> " + matrizCountDupla[i][j]);
                }
            }
        }
    }
    
    public void jogar(){
        int i, j;
        String jogadores[] = new String[4];
        int jogadas[][] = new int[4][6];

	System.out.println("\n");
	for(i = 0 ; i < 6 ; i++){
            System.out.println(" | " +  this.matriz[2999][i]);
	}
	System.out.println("\n");
        
        for(i = 0 ; i < 3 ; i++){
            System.out.println("Jogador " + (i+1));
            jogadores[i] = scanner.next();

            System.out.println("\nInforme os 6 numeros\n");

            for(j = 0 ; j < 6 ; j++){
                jogadas[i][j] = scanner.nextInt();
            }
        }
    
	for(i = 0 ; i < 3 ; i++){
            System.out.println("\nJogador "+ (i + 1) + " " + jogadores[i]);
            for(j = 0 ; j < 6 ; j++){
                System.out.println(jogadas[i][j] + " ");
            }
        }
    
	//--------------------------------------------------	
	int x, y, z;
        int acertos[][] = new int[3][1];
			  		 
	acertos[0][0] = 0;
	acertos[1][0] = 0;		  		 
	acertos[2][0] = 0;
			  		 		  		 
        for(y = 0; y < 6; y++){
            for(j = 0 ; j < 3 ; j++){
	        for(z = 0 ; z < 6 ; z++){
                    if(this.matriz[2999][y] == jogadas[j][z]){
    			acertos[j][0] = acertos[j][0] + 1;
                    }
	        }
            }             
	}
	
	for(y = 0; y < 3; y++){
            System.out.println("\nParabens " + jogadores[y] + ", voce acertou " + acertos[y][0] + " numeros!");
	}   
    }
}
