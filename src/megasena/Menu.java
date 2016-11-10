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
        System.out.println("-------------------------------------");
        System.out.println("-------------Mega Sena---------------");
        System.out.println("-------------1 Sortear---------------");
        System.out.println("-------------2 Dados-----------------");
        System.out.println("-------------3 Jogar-----------------");
        System.out.println("-------------0 Sair------------------");
        System.out.println("-------------------------------------");
        System.out.println("Digite a opcao desejada: "); 
        
        Scanner scanner = new Scanner(System.in);
        int op;        
        op = scanner.nextInt();
        //System.out.println(op);
        switch(op){
            case 1 :
                int matriz[][] = new int[3000][6];
                Jogos jogos = new Jogos();
		jogos.popularJogos();
                jogos.mostrarJogos();
		//mostrarJogos(jogos);	
            break;
            case '2' : 
            	//mostrarCountNumeros(countNumeroX);  
		//duplasMaisSorteadas(jogos);         
            break;
            case '3' : 
		//jogar(jogos);
            break;
            case '0' : 
		//printf("\nObrigado por jogar, volte sempre.\n");    
		//exit(0);
            default  : 
		//printf("\nOpcao nao encontrada, digite novamente\n");
                //getch();                        
            break;
        }
    }
}
