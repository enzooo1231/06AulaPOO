package Exercicio04;

import java.time.Duration;
import java.time.LocalTime;

public class Registro {
    Veiculo veiculo;
    String horaInic;
    String horaSaida;

    public Registro(Veiculo veiculo, String horaInic) {
        this.veiculo = veiculo;
        this.horaInic = horaInic;
    }

    double calcularValor(){
        LocalTime inicio,fim;
        double valor;
        long minutos;

        inicio = LocalTime.parse(horaInic);
        fim = LocalTime.parse(horaSaida);

        minutos = Duration.between(inicio, fim).toMinutes();
        valor = minutos * 0.75;

        return valor;

    }
}
