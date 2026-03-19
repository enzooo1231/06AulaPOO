package Exercicio03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {
    static BilheteUnico [] bilhete = new BilheteUnico[3];
    static Scanner sc = new Scanner(System.in);
    static int index;


    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("[1] Cadastrar bilhete");
            System.out.println("[2] Carregar bilhete");
            System.out.println("[3] Consultar saldo");
            System.out.println("[4] Passar na catraca");
            System.out.println("[5] Finalizar");
            opcao = sc.nextInt();

            switch (opcao){
                case 1 -> cadastrar();
                case 2 -> carregar();
                case 3 -> consultarSaldo();
                case 4 -> passarNaCatraca();
                case 5 -> System.out.println("Até Breve!");
                default -> System.out.println("Opção inválida!");
            }
            System.out.println("\n");
            System.out.println("--------------------------------------------------------");
        }while(opcao != 5);
    }

    private static void passarNaCatraca() {

        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null){
            if (bilheteUnico.passarNaCatraca() == false){
                System.out.println("Saldo Insuficiente");
            };
            System.out.println("Saldo Atual R$" +bilheteUnico.saldo);
        }

    }

    private static void consultarSaldo() {

        DecimalFormat df = new DecimalFormat("#,##0.00");

        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null){
            System.out.println("Valor disponivel: " + df.format(bilheteUnico.saldo));
        }
    }

    private static void carregar() {
        double valor;
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null){
            System.out.println("Digite o valor da recarga: ");
            valor = sc.nextDouble();
            bilheteUnico.carregar(valor);
        }
    }

   private static void cadastrar() {
        String nome;
        long cpf;
        String tipoTarifa;

        if (index < bilhete.length){
            System.out.println("Nome do usuário: ");
            nome = sc.next();
            System.out.println("CPF: ");
            cpf = sc.nextLong();
            System.out.println("Tipo de tarifa (estudante | professor | comum): ");
            tipoTarifa = sc.next();
            bilhete[index] = new BilheteUnico(new Usuario(nome, tipoTarifa, cpf));
            index++;
        }else {
            System.out.println("Erro ao gerar o bilhete! Procure um posto de atendimento");
        }
    }

    static BilheteUnico pesquisar(){
        long cpf;
         System.out.println("Qual CPF, para pesquis? ");
         cpf = sc.nextLong();

         for (int i = 0; i < index; i++){
             if (bilhete[i].usuario.cpf == cpf){
                 return bilhete[i];
             }
         }
         System.out.println("CPF não encontrado");
         return null;
     }



}
