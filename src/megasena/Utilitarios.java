/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;



/**
 *
 * @author internet
 */
public class Utilitarios {
    
    public void Bubble_Sort(int vet[], int tam){

        int i, j;
        int aux;

        for (i=1; i<tam;i++){
            for (j=0;j<tam-i;j++){
                  if (vet[j] > vet[j+1]){
                         aux = vet[j];
                         vet[j] = vet[j+1];
                         vet[j+1] = aux;
                  }
             }
          }
    }
}
