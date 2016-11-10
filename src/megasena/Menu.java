/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;

import java.util.Scanner;

/**
 *
 * @author Ricardo Mota
 */
public class Menu {
    public Menu(){
        int op; 
        boolean end = true;
        Jogos jogos = new Jogos();
        while(true){
            System.out.println("-------------------------------------");
            System.out.println("-------------Mega Sena---------------");
            System.out.println("-------------1 Sortear---------------");
            System.out.println("-------------2 Dados-----------------");
            System.out.println("-------------3 Jogar-----------------");
            System.out.println("-------------0 Sair------------------");
            System.out.println("-------------------------------------");
            System.out.println("Digite a opcao desejada: "); 

            Scanner scanner = new Scanner(System.in);
            
            op = scanner.nextInt();
            //System.out.println(op);
            switch(op){
                case 1 :
                    //int matriz[][] = new int[3000][6];
                    
                    jogos.popularJogos();
                    //jogos.mostrarJogos();	
                break;
                case 2 : 
                    jogos.mostrarCountNumeros();  
                    //duplasMaisSorteadas(jogos);         
                break;
                case 3 : 
                    //jogar(jogos);
                break;
                case 0 : 
                    System.out.println("\nObrigado por jogar, volte sempre.\n");    
                    return;
                default  : 
                    //printf("\nOpcao nao encontrada, digite novamente\n");
                    //getch();                        
                break;
            }
        }
    }
}
