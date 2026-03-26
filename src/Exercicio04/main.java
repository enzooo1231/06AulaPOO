package Exercicio04;

import java.time.LocalTime;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    static Veiculo [] veiculo = new Veiculo[3];
    static int indexVeiculo;
    static int indexRegistro;
    static Registro [] registro = new Registro[20];


    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("### Estacionamento ParkEasy ###");
            System.out.println("[1] Entrada de veículo: ");
            System.out.println("[2] Saída de veículo: ");
            System.out.println("[3] Imprimir veículos estacionados: ");
            System.out.println("[4] Imprimir a receita:");
            System.out.println("[5] Finalizar");

            opcao = sc.nextInt();

            switch(opcao){
                case 1 -> cadastroVeiculo();
                case 2 -> cadastroSaida();
                case 3 -> imprimirVeic();
                case  4 -> imprimirReceita();
            }

        }while(opcao != 5);
    }

    private static void imprimirReceita() {
        double valor =0;

        for (int i=0; i < indexRegistro; i++){
            if (registro[i].horaSaida != null){
                valor+=registro[i].calcularValor();
            }
        }
        System.out.println("Receita total R$: " +valor);
    }

    static void cadastroSaida() {

        String horaSai;
        double valor;

        Registro registro = pesquisaRegistro();



        if (registro != null){
            System.out.println("Hora da saída (hh:mm) --> ");
            horaSai = sc.next();

            registro.horaSaida = horaSai;
            valor = registro.calcularValor();
            System.out.println("Valor total a pagar R$: " +valor);

        }else {
            System.out.println("Veículo não registrado no sistema!");
        }
    }

    static Registro pesquisaRegistro(){
        String placa;

        System.out.println("Digite a placa do veiculo: ");
        placa = sc.next().toUpperCase();

        for (int i=0; i < indexRegistro; i++){
            if (registro[i].veiculo.placa.equals(placa)){
                return registro[i];
            }

        }
        System.out.println("Placa não encontrada!");
        return null;

    }

    private static void imprimirVeic() {
        for (int i=0; i < indexRegistro; i++){
            if (registro[i].horaSaida == null)
            System.out.println(registro[i].veiculo.placa);
        }
    }

    private static void cadastroVeiculo() {
        String nome;
        String marca ;
        String modelo, placa;
        String horaEntr;

        long cpf;

        Veiculo veiculoEncontrado = pesquisa();

        if (veiculoEncontrado == null){
            System.out.println("Nome do Proprietário");
            nome = sc.next();
            System.out.println("CPF:");
            cpf = sc.nextLong();
            System.out.println("Placa:");
            placa = sc.next().toUpperCase();
            System.out.println("Marca do Veículo: ");
            marca = sc.next();
            System.out.println("Modelo do veículo: ");
            modelo = sc.next();

            Proprietario proprietario = new Proprietario(nome, cpf);
            veiculoEncontrado = new Veiculo(marca, modelo,placa, proprietario);
            veiculo[indexVeiculo] = veiculoEncontrado;
            indexVeiculo++;
        }

            System.out.println("Hora da entrada (HH:mm) : ");
            horaEntr = sc.next();
            registro[indexRegistro++] = new Registro(veiculoEncontrado, horaEntr);


    }

    static Veiculo pesquisa(){
        String placa;

        System.out.println("Digite a placa do veiculo: ");
        placa = sc.next().toUpperCase();

        for (int i=0; i < indexVeiculo; i++){
            if (veiculo[i].placa.equals(placa)){
                return veiculo[i];
            }

        }
        System.out.println("Placa não encontrada!");
        return null;

    }

}
