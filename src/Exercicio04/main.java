package Exercicio04;

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

                case 3 -> imprimirVeic();
            }

        }while(opcao != 5);
    }

    private static void imprimirVeic() {
        for (int i=0; i < indexRegistro; i++){
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
            veiculo[indexVeiculo++] = new Veiculo(marca, modelo, placa, proprietario);
        }else{
            System.out.println("Hora da entrada (HH:mm) : ");
            horaEntr = sc.next();
            registro[indexRegistro++] = new Registro(veiculoEncontrado, horaEntr);
        }

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
