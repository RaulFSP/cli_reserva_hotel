/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package io.github;

import java.util.Scanner;

import io.github.entity.Reserva;

/**
 *
 * @author usuario
 */
public class Cli_reserva_hotel {

    private static Reserva[] reservas = new Reserva[10];
    private static String[] tipoQuartos = {"Standard","Luxo","Presidencial"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuPrincipal(sc);
    }
    static void menuPrincipal(Scanner sc){
        System.out.println("""
                ###Hotel Reservas###
                1 - Nova reserva
                2 - Listar reservas
                3 - Buscar reserva por hospede
                4 - Ordernar reservas por número por dias
                5 - sair
                ####################
                """);
        String entrada = sc.nextLine();
        entrada = entrada.trim();
        switch (entrada) {
            case "1"->{
                novaReserva(sc);
                menuPrincipal(sc);
            }
            case "2"->{

            }
            case "3"->{

            }
            case "4"->{

            }
            case "5"-> System.exit(1);
            default -> menuPrincipal(sc);
                
        }
    }
    static void novaReserva(Scanner sc){
        System.out.println("Digite o nome do Hóspede");
        String nome = sc.nextLine();
        nome = nome.trim();
        if(nome.equals("")){
            System.out.println("Nome inválido");
        }
        System.out.println("""
                Escolha o tipo do quarto
                1 - Standard
                2 - Luxo
                3 - Presidencial
                4 - cancelar
                """);        
        String entrada = sc.nextLine();

    }

    
}   
