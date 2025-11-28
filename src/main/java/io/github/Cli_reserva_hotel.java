package io.github;
import java.util.Scanner;
import io.github.entity.Reserva;

public class Cli_reserva_hotel {
    private final static Reserva[] reservas = new Reserva[10];
    private final static String[] tipoQuartos = {"Standard","Luxo","Presidencial"};
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
                listarReservas();
                menuPrincipal(sc);
            }
            case "3"->{
                buscarPorHospede(sc);
                menuPrincipal(sc);
            }
            case "4"->{
        ordernarReservasPorDias();
        menuPrincipal(sc);
            }
            case "5"-> System.exit(1);
            default -> menuPrincipal(sc);
                
        }
    }
    static void novaReserva(Scanner sc){
        String nome = selecionarNomeHospede(sc);
        String tipoQuarto =   selecionarTipoQuarto(sc);
        Integer diasQuantidade = selecionarDiasQuantidade(sc);
        Double valorDiaria = selecionarValorReserva(sc);
        Reserva novaReserva = new Reserva(nome,tipoQuarto,diasQuantidade,valorDiaria);
        adicionarReserva(novaReserva);
    }
    static String selecionarNomeHospede(Scanner sc){
    System.out.println("Digite o nome do Hóspede");
    String nome = sc.nextLine();
    nome = nome.trim();
    if(nome.isEmpty()){
        System.out.println("Nome inválido");
        novaReserva(sc);
    }
    return nome;
}
    static String selecionarTipoQuarto(Scanner sc){
        System.out.println("""
                Escolha o tipo do quarto
                1 - Standard
                2 - Luxo
                3 - Presidencial
                4 - cancelar
                """);
        String entrada = sc.nextLine();
        String tipoQuarto = "";
        try{
            Integer escolha =Integer.parseInt( entrada.trim())-1;
            if(escolha == 3){
                menuPrincipal(sc);
            }
            tipoQuarto = tipoQuartos[escolha];
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("O número não é válido!");
            selecionarTipoQuarto(sc);
        }
        catch(NumberFormatException ex){
            System.out.println("A entrada não é um número");
            selecionarTipoQuarto(sc);
        }
        return tipoQuarto;
    }
    static Integer selecionarDiasQuantidade(Scanner sc){
        System.out.println("Digite o número de dias de estadia do hóspede");
        String entrada = sc.nextLine().trim();
        Integer dias = null;
        try{
            dias = Integer.parseInt(entrada);
            if(dias < 1){
                System.out.println("A quantidade de dias não pode ser menor que 1");
                return selecionarDiasQuantidade(sc);
            }
            return dias;
        } catch(NumberFormatException ex){
            System.out.println("A entrada não é um número válido!");
            return selecionarDiasQuantidade(sc);
        }

    }
    static  Double selecionarValorReserva(Scanner sc){
        System.out.println("Digite o valor da diária ");
        String entrada = sc.nextLine().trim();
        Double valorDiaria = 0.0;
        try{
            valorDiaria = Double.parseDouble(entrada);
            if(valorDiaria < 0){
                System.out.println("Valor negativo não é aceito");
                return selecionarValorReserva(sc);
            }
            return valorDiaria;
        } catch (NumberFormatException ex){
            System.out.println("Não é um número");
            return selecionarValorReserva(sc);
        }

    }
    static void adicionarReserva(Reserva novaReserva){
        for(int i = 0; i < reservas.length; i++){
            if(reservas[i] == null){
                reservas[i] = novaReserva;
                System.out.println("=========================");
                System.out.println("A reserva de %s foi criada".formatted(novaReserva.getNomeHospede()));
                System.out.println("=========================");
                break;
            } else {
                System.out.println("""
                        Não foi possível criar um nova reserva!
                        Não há reservas disponíveis.
                        """);
            }
        }
    }
    static void listarReservas(){
        System.out.println("=========================");
        System.out.println("====Reservas Efetuadas====");
        System.out.println("=========================");
        System.out.println("ID\tHospede\tCategoria\tDias Estadia\tValor Total");
        int cont = 0;
        for(Reserva reserva : reservas){
            if(reserva != null){
                System.out.println(cont+"\t"+reserva);
                cont++;
            }
        }
        System.out.println("=========================");
    }
    static void buscarPorHospede(Scanner sc){
        System.out.println("=========================");
        System.out.println("Digite o nome do hóspede");
        String nomeHospede = sc.nextLine().trim();
        if(nomeHospede.isEmpty()){
            System.out.println("Nome inválido");
            buscarPorHospede(sc);
        }
        Reserva[] reservasEncontradas = new Reserva[10];
        int cont = 0;
        for(Reserva reserva : reservas){
            if(reserva != null && reserva.getNomeHospede().equals(nomeHospede)){
                reservasEncontradas[cont] = reserva;
                cont++;
            }
        }

        for(Reserva reserva : reservasEncontradas){
            if(reserva != null){
                System.out.println(reserva);

            } else {
                break;
            }
        }
        System.out.println("=========================");
    }
    static void ordernarReservasPorDias(){
        for(int i = 0; i < reservas.length;i++){
            for(int j = 0; j < reservas.length-1;j++){
                if(reservas[j]!= null && reservas[j+1] !=null){
                    if(reservas[j].getDiasQuantidade() < reservas[j+1].getDiasQuantidade()){
                        Reserva temp = reservas[j+1];
                        reservas[j+1] = reservas[j];
                        reservas[j] = temp;
                    }
                }
            }
        }
        System.out.println("=========================");
        System.out.println("Ordenamento realizado!");
        System.out.println("=========================");
    }
}   
