package Exercicio01;

public class main {
    public static void main(String[] args) {
        MonitorEnergia monitor = new MonitorEnergia(100);
        monitor.registro(1);
        monitor.registro(3);
        monitor.registro(2);
        monitor.registro(3);
        monitor.registro(2);

        System.out.println("Média de consumo até o momento: " + monitor.calculaMedia());
        System.out.println("Média em um intervalo de dias:  " +monitor.calculaMedia(2,4));
    }

}
