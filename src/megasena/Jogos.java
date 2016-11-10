/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;

import java.util.Random;

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
        //System.out.println("teste");
        for (this.linha = 0; this.linha < 3000; this.linha++) {
            final int[] sorteio = random.ints(1, 61).distinct().limit(this.quantidadeDeNumeroSorteado).toArray();
            for (this.coluna = 0; this.coluna < this.quantidadeDeNumeroSorteado; this.coluna++) {
                //System.out.println(sorteio[this.coluna]);
                this.matriz[this.linha][this.coluna] = sorteio[this.coluna];
                for (int i = 0; i < 61; i++) {
                    if(this.countNumeroX[i][0] == this.matriz[this.linha][this.coluna]) {
                        this.countNumeroX[i][1] = this.countNumeroX[i][1] + 1;
                    }
                }
            }
        }
      System.out.println("aquiiii:" + this.countNumeroX[1][1]);
  
    }
    public void mostrarJogos(){
        //System.out.println("teste1");
        String resultado = "", resultadoFinal = "", resultadoOrdenado = "";
        int vetorOrdenado[] = new int[6];
        Sort sort = new Sort();
        
        for (this.linha = 0; this.linha < 3000; this.linha++) {
            for(this.coluna = 0; this.coluna < this.quantidadeDeNumeroSorteado; this.coluna++){
                resultado = resultado + String.format("%1$02d ", this.matriz[this.linha][this.coluna]);
                vetorOrdenado[this.coluna] = this.matriz[this.linha][this.coluna];
            }
            sort.bubbleSort(vetorOrdenado, this.quantidadeDeNumeroSorteado);
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
}
