package Exercicio03;

import java.util.Random;

public class BilheteUnico {
    int numero;
    double saldo;
    String tipoTarifa;
    Usuario usuario;
    final static double tarifaBase = 5.45;

    public BilheteUnico(Usuario usuario) {
        Random random = new Random();
        this.numero = gerarNumero();
        this.usuario = usuario;
        this.saldo = 0;
    }

    int gerarNumero(){
        Random random = new Random();

        return random.nextInt(1000, 9999);
    }


    public void carregar(double valor) {
        saldo += valor;
    }

    double calcularTarifa(){
        double valor = tarifaBase;
        if (usuario.tipoTarifa.equalsIgnoreCase("Esudante") || usuario.tipoTarifa.equalsIgnoreCase("Professor")){
            valor = tarifaBase / 2;
        }
        return valor;
    }

    public boolean passarNaCatraca() {
        double valor = calcularTarifa();


        // verifica se tem saldo disponível
        if(saldo <= valor) {
            saldo = saldo - valor;
            return true;
        }
        return false;

    }
}
